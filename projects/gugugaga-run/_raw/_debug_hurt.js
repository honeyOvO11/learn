// 调试：定位机器人受伤时的障碍组合（复用 harness 的 stub 环境）
const fs = require('fs');
const vm = require('vm');
const path = 'D:/tangOvO1/learn/gugugaga快跑/index.html';
const html = fs.readFileSync(path, 'utf8');
const m = html.match(/<script>([\s\S]*?)<\/script>/);
let code = m[1];
code += `
globalThis.__step = (dt) => { if (AC) AC.__t += dt; demoThink(); update(dt); };
globalThis.__start = () => startGame();
`;
function makeEl(id) {
  const cls = new Set();
  return {
    id, textContent: '', innerHTML: '', disabled: false, offsetWidth: 100,
    style: {}, width: 0, height: 0,
    classList: {
      add: c => cls.add(c), remove: c => cls.delete(c),
      toggle: (c, f) => { if (f === undefined) { cls.has(c) ? cls.delete(c) : cls.add(c); } else { f ? cls.add(c) : cls.delete(c); } },
      contains: c => cls.has(c)
    },
    addEventListener: () => {},
    getContext: () => ctxStub,
    closest: () => null,
  };
}
const ctxStub = new Proxy({}, { get: (t, k) => (k === Symbol.toPrimitive ? () => '' : (...a) => ctxStub), set: () => true });
class FakeOsc { constructor() { this.type = ''; this.frequency = { setValueAtTime() {}, exponentialRampToValueAtTime() {} }; } connect() {} start() {} stop() {} }
class FakeNode { constructor() { this.gain = { value: 0, setValueAtTime() {}, linearRampToValueAtTime() {}, exponentialRampToValueAtTime() {} }; this.frequency = { value: 0 }; } connect() {} }
class FakeAC { constructor() { this.__t = 0; this.sampleRate = 44100; this.destination = {}; this.state = 'running'; } get currentTime() { return this.__t; } createGain() { return new FakeNode(); } createOscillator() { return new FakeOsc(); } createBiquadFilter() { return new FakeNode(); } createBuffer() { return { getChannelData: () => new Float32Array(16) }; } createBufferSource() { return { buffer: null, connect() {}, start() {} }; } resume() { this.state = 'running'; } suspend() { this.state = 'suspended'; } }
const els = {};
const docStub = {
  getElementById: id => els[id] || (els[id] = makeEl(id)),
  addEventListener: () => {},
  hidden: false,
};
const sandbox = {
  document: docStub,
  window: { AudioContext: FakeAC },
  location: { search: '?demo=1' },
  localStorage: { getItem: () => null, setItem: () => {} },
  Image: class { set src(v) { setTimeout(() => this.onload && this.onload(), 0); } onload = null; },
  requestAnimationFrame: () => 0,
  setInterval: () => 0,
  clearInterval: () => {},
  performance: { now: () => 0 },
  fetch: () => Promise.resolve({ ok: true }),
  navigator: { userAgent: 'node', platform: 'node' },
};
vm.createContext(sandbox);
try { vm.runInContext(code, sandbox, { filename: 'game.js' }); } catch (e) { console.error('load fail', e.message); process.exit(1); }
const DT = 1 / 60;
// 挂钩 1：spawnPattern 前后 nextSpawnBeat
vm.runInContext(`
globalThis.__patternLog = [];
const __origPattern = spawnPattern;
spawnPattern = function(){ const b0 = game.nextSpawnBeat; const pb = currentBeat(); __origPattern(); globalThis.__patternLog.push({t: Math.round(game.t*10)/10, pbeat: Math.round(pb*100)/100, before: Math.round(b0*100)/100, after: Math.round(game.nextSpawnBeat*100)/100}); };
`, sandbox);
// 挂钩 2：demoThink 状态轨迹
vm.runInContext(`
globalThis.__stateLog = [];
const __origThink = demoThink;
demoThink = function(){ __origThink(); if (game.mode === 'running' && globalThis.__stateLog.length < 3000) { const danger = game.obstacles.filter(o => o.y > GROUND - 130 && o.x > -50 && o.x < pl.x + 400).map(o => ({k:o.kind, x:Math.round(o.x)})); const rc = game.obstacles.some(o => (o.kind === 'roof' || o.kind === 'barrier') && o.x + o.w > pl.x - 30 && o.x < pl.x + 240); const nn = game.notes.filter(n => !n.taken && n.x > pl.x - 60 && n.x < pl.x + 400).map(n => Math.round(n.x) + (n.y < GROUND - 70 ? 'H' : 'L')).join(','); globalThis.__stateLog.push({t: Math.round(game.t*10)/10, y: Math.round(pl.y), g: pl.grounded ? 1 : 0, j: pl.jumps, jb: Math.round(pl.jumpBuf*100), cr: pl.crouching ? 1 : 0, rc: rc ? 1 : 0, obs: danger.length ? danger.map(o => o.k + ':' + o.x).join(',') : '-', n: nn || '-'}); } };
`, sandbox);
// 挂钩 3：障碍生成记录（含 spawnX）
vm.runInContext(`
globalThis.__spawnLog = [];
const __origObstacle = spawnObstacle;
spawnObstacle = function(){ const ret = __origObstacle(); const b = currentBeat(); const obs = game.obstacles.filter(x => x.spawnT === undefined); obs.forEach(o => { o.spawnX = o.x; o.spawnT = b; }); globalThis.__spawnLog.push({t: Math.round(game.t*10)/10, beat: b, obs: obs.map(x => ({kind:x.kind, sx:Math.round(x.spawnX)}))}); return ret; };
const __origBarrier = spawnBarrier;
spawnBarrier = function(){ __origBarrier(); const b = currentBeat(); const obs = game.obstacles.filter(x => x.spawnT === undefined); obs.forEach(o => { o.spawnX = o.x; o.spawnT = b; }); globalThis.__spawnLog.push({t: Math.round(game.t*10)/10, beat: b, obs: obs.map(x => ({kind:x.kind, sx:Math.round(x.spawnX)}))}); };
const __origRoof = spawnRoof;
spawnRoof = function(){ __origRoof(); const b = currentBeat(); const obs = game.obstacles.filter(x => x.spawnT === undefined); obs.forEach(o => { o.spawnX = o.x; o.spawnT = b; }); globalThis.__spawnLog.push({t: Math.round(game.t*10)/10, beat: b, obs: obs.map(x => ({kind:x.kind, sx:Math.round(x.spawnX)}))}); };
const __origMixed = spawnMixed;
spawnMixed = function(){ __origMixed(); const b = currentBeat(); const obs = game.obstacles.filter(x => x.spawnT === undefined); obs.forEach(o => { o.spawnX = o.x; o.spawnT = b; }); globalThis.__spawnLog.push({t: Math.round(game.t*10)/10, beat: b, obs: obs.map(x => ({kind:x.kind, sx:Math.round(x.spawnX)}))}); };
`, sandbox);
// 挂钩 4：每次受伤打印现场
vm.runInContext(`
const __origDamage = damagePlayer;
globalThis.__hurtLog = null;
damagePlayer = function(k, s){
  const obs = game.obstacles.map(o => ({kind:o.kind, x:Math.round(o.x), y:Math.round(o.y), h:Math.round(o.h), dead:o.dead, st: o.spawnT === undefined ? -1 : Math.round(o.spawnT*10)/10})).filter(o => !o.dead && o.x > -100 && o.x < 1000);
  const notes = game.notes.filter(n => !n.taken && n.x > 0 && n.x < 1000).map(n => Math.round(n.x));
  globalThis.__hurtLog = 'HURT t=' + Math.round(game.t*10)/10 + ' hearts=' + game.hearts + ' plY=' + Math.round(pl.y) + ' jumps=' + pl.jumps + ' crouch=' + pl.crouching + ' buf=' + Math.round(pl.crouchBuf*100)/100 + ' spd=' + Math.round(game.speed) + ' k=' + (k||'?') + '\\n  obs=' + JSON.stringify(obs) + (notes.length ? ('\\n  notes=' + JSON.stringify(notes)) : '') + '\\n  stateTail=' + JSON.stringify(globalThis.__stateLog.slice(-80)) + '\\n  patternLog=' + JSON.stringify(globalThis.__patternLog) + '\\n  spawnLog=' + JSON.stringify(globalThis.__spawnLog);
  __origDamage(k, s);
}`, sandbox);
setTimeout(() => {
  for (let attempt = 0; attempt < 40; attempt++) {
    vm.runInContext('startGame();', sandbox);
    let guard = 0;
    let hurtAt = null;
    // 每局开始前重置
    vm.runInContext('globalThis.__hurtLog = null; globalThis.__spawnLog = []; globalThis.__patternLog = []; globalThis.__stateLog = [];', sandbox);
    while (vm.runInContext('game.mode', sandbox) === 'running' && guard < 9000) {
      vm.runInContext('__step(' + DT + ');', sandbox);
      if (vm.runInContext('globalThis.__hurtLog', sandbox)) { hurtAt = guard; break; }
      guard++;
    }
    if (hurtAt !== null) {
      console.log('=== 抓到受伤 attempt=' + attempt + ' frame=' + hurtAt + ' ===');
      console.log(vm.runInContext('globalThis.__hurtLog', sandbox));
      break;
    }
    console.log('attempt ' + attempt + ' 无伤 -> ' + vm.runInContext('game.mode', sandbox) + ' t=' + Math.round(vm.runInContext('game.t', sandbox) * 10) / 10);
  }
}, 30);
