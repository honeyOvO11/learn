const fs = require('fs');
const vm = require('vm');
const html = fs.readFileSync('D:/tangOvO1/learn/gugugaga快跑/index.html', 'utf8');
const m = html.match(/<script>([\s\S]*?)<\/script>/);
let code = m[1];
code += `
globalThis.__probe = () => ({
  t: Math.round(game.t * 100) / 100, notesGot: game.notesGot, score: game.score,
  notes: game.notes.map(n => ({ x: Math.round(n.x), y: Math.round(n.y), hi: n.y < GROUND - 70, tk: n.taken })),
  obs: game.obstacles.map(o => ({ x: Math.round(o.x), k: o.kind, dead: o.dead })),
  py: Math.round(pl.y), jumps: pl.jumps, grounded: pl.grounded, jb: Math.round(pl.jumpBuf * 100) / 100,
  spd: Math.round(game.speed), mode: game.mode, runT: Math.round(game.runT), beat: Math.round(currentBeat() * 100) / 100,
  nextSpawn: Math.round(game.nextSpawnBeat * 100) / 100
});
let __urCalls = 0;
const __origUR = updateRunning;
updateRunning = function(dt) { __urCalls++; return __origUR(dt); };
globalThis.__urCalls = () => __urCalls;
globalThis.__step = (dt) => { if (AC) AC.__t += dt; demoThink(); update(dt); };
globalThis.__start = () => startGame();
`;
function makeEl(id) {
  const cls = new Set();
  return { id, textContent: '', innerHTML: '', disabled: false, offsetWidth: 100, style: {}, width: 0, height: 0,
    classList: { add: c => cls.add(c), remove: c => cls.delete(c), toggle: () => {}, contains: c => cls.has(c) },
    addEventListener: () => {}, getContext: () => ctxStub, closest: () => null };
}
const ctxStub = new Proxy({}, { get: (t, k) => (k === Symbol.toPrimitive ? () => '' : (...a) => ctxStub), set: () => true });
class FakeOsc { constructor() { this.type = ''; this.frequency = { setValueAtTime() {}, exponentialRampToValueAtTime() {} }; } connect() {} start() {} stop() {} }
class FakeNode { constructor() { this.gain = { value: 0, setValueAtTime() {}, linearRampToValueAtTime() {}, exponentialRampToValueAtTime() {} }; this.frequency = { value: 0 }; } connect() {} }
class FakeAC { constructor() { this.__t = 0; this.sampleRate = 44100; this.destination = {}; this.state = 'running'; }
  get currentTime() { return this.__t; }
  createGain() { return new FakeNode(); } createOscillator() { return new FakeOsc(); }
  createBiquadFilter() { return new FakeNode(); } createBuffer() { return { getChannelData: () => new Float32Array(16) }; }
  createBufferSource() { return { buffer: null, connect() {}, start() {} }; } resume() { this.state = 'running'; } suspend() { this.state = 'suspended'; } }
const els = {};
const docStub = { getElementById: id => els[id] || (els[id] = makeEl(id)), addEventListener: () => {}, hidden: false };
const sandbox = { document: docStub, window: { AudioContext: FakeAC }, location: { search: '?demo=1' },
  localStorage: { getItem: () => null, setItem: () => {} },
  Image: class { set src(v) { setTimeout(() => this.onload && this.onload(), 0); } onload = null; },
  requestAnimationFrame: () => 0, setInterval: () => 0, clearInterval: () => {}, console, performance, setTimeout, clearTimeout };
sandbox.globalThis = sandbox;
vm.createContext(sandbox);
vm.runInContext(code, sandbox);
const step = (dt) => vm.runInContext('__step(' + dt + ')', sandbox);
const probe = () => vm.runInContext('__probe()', sandbox);
setTimeout(() => {
vm.runInContext('__start()', sandbox);
const DT = 1 / 60;
for (let i = 0; i < 480; i++) {
  step(DT);
  if (i % 30 === 0) {
    const p = probe();
    console.log('t=' + p.t + ' notesGot=' + p.notesGot + ' score=' + p.score + ' py=' + p.py + ' j=' + p.jumps + ' g=' + p.grounded + ' jb=' + p.jb + ' spd=' + p.spd + ' mode=' + p.mode + ' runT=' + p.runT + ' beat=' + p.beat + ' nextSpawn=' + p.nextSpawn + ' ur=' + vm.runInContext('globalThis.__urCalls()', sandbox) +
      ' notes=' + p.notes.map(n => n.x + (n.hi ? 'H' : 'L') + (n.tk ? '*' : '')).join(',') +
      ' obs=' + p.obs.map(o => o.x + o.k).join(','));
  }
}
}, 30);
