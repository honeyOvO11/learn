const fs = require('fs');
const vm = require('vm');
const html = fs.readFileSync('D:/tangOvO1/learn/gugugaga快跑/index.html', 'utf8');
let code = html.match(/<script>([\s\S]*?)<\/script>/)[1];
code += `
globalThis.__probe = () => ({ mode: game.mode, hearts: game.hearts, bossHp: game.bossHp, bossMode: boss.mode, bossVx: boss.vx, py: Math.round(pl.y), jumps: pl.jumps, grounded: pl.grounded, t: Math.round(game.t * 10) / 10 });
globalThis.__step = (dt) => { if (AC) AC.__t += dt; update(dt); demoThink(); };
globalThis.__start = () => startGame();
`;
function makeEl(id) { const cls = new Set(); return { id, textContent: '', innerHTML: '', disabled: false, offsetWidth: 100, style: {}, classList: { add: c => cls.add(c), remove: c => cls.delete(c), toggle: (c, f) => { if (f === undefined) { cls.has(c) ? cls.delete(c) : cls.add(c); } else { f ? cls.add(c) : cls.delete(c); } }, contains: c => cls.has(c) }, addEventListener: () => {}, getContext: () => ctxStub, closest: () => null }; }
const ctxStub = new Proxy({}, { get: (t, k) => (k === Symbol.toPrimitive ? () => '' : (...a) => ctxStub), set: () => true });
class FakeOsc { constructor() { this.type = ''; this.frequency = { setValueAtTime() {}, exponentialRampToValueAtTime() {} }; } connect() {} start() {} stop() {} }
class FakeNode { constructor() { this.gain = { value: 0, setValueAtTime() {}, linearRampToValueAtTime() {}, exponentialRampToValueAtTime() {} }; this.frequency = { value: 0 }; } connect() {} }
class FakeAC { constructor() { this.__t = 0; this.sampleRate = 44100; this.destination = {}; this.state = 'running'; } get currentTime() { return this.__t; } createGain() { return new FakeNode(); } createOscillator() { return new FakeOsc(); } createBiquadFilter() { return new FakeNode(); } createBuffer() { return { getChannelData: () => new Float32Array(16) }; } createBufferSource() { return { buffer: null, connect() {}, start() {} }; } resume() { this.state = 'running'; } suspend() { this.state = 'suspended'; } }
const els = {};
const docStub = { getElementById: id => els[id] || (els[id] = makeEl(id)), addEventListener: () => {}, hidden: false };
const sandbox = { document: docStub, window: { AudioContext: FakeAC }, location: { search: '?demo=1' }, localStorage: { getItem: () => null, setItem: () => {} }, Image: class { set src(v) { setTimeout(() => this.onload && this.onload(), 0); } onload = null; }, requestAnimationFrame: () => 0, setInterval: () => 0, clearInterval: () => {}, console, performance, setTimeout, clearTimeout };
vm.createContext(sandbox);
vm.runInContext(code, sandbox);
const probe = () => vm.runInContext('__probe()', sandbox);
const step = (dt) => vm.runInContext('__step(' + dt + ')', sandbox);
const start = () => vm.runInContext('__start()', sandbox);
const DT = 1 / 60;
setTimeout(() => {
  start();
  let guard = 0;
  while (probe().mode !== 'boss' && guard < 2500) { step(DT); guard++; }
  console.log('== boss reached ==', JSON.stringify(probe()));
  guard = 0;
  let lastMode = '';
  while (probe().mode === 'boss' && guard < 3000) {
    const p = probe();
    if (p.bossMode !== lastMode && p.bossMode.indexOf('Telegraph') >= 0) {
      console.log('pattern:', p.bossMode, 'at t=' + p.t, 'hearts=' + p.hearts);
      lastMode = p.bossMode;
    }
    step(DT); guard++;
  }
  console.log('== final ==', JSON.stringify(probe()));
  process.exit(0);
}, 30);
