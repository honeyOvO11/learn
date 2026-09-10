const fs = require('fs');
const vm = require('vm');
const path = 'D:/tangOvO1/learn/gugugaga快跑/index.html';
const html = fs.readFileSync(path, 'utf8');
const m = html.match(/<script>([\s\S]*?)<\/script>/);
let code = m[1];
code += `
globalThis.__probe = () => ({
  mode: game.mode, score: game.score, notesGot: game.notesGot, hearts: game.hearts,
  bossHp: game.bossHp, bossActive: boss.active, bossMode: boss.mode,
  obstacles: game.obstacles.length, notes: game.notes.length, waves: game.waves.length, items: game.items.length,
  grounded: pl.grounded, jumps: pl.jumps, t: Math.round(game.t * 10) / 10, runT: Math.round(game.runT * 10) / 10,
  winHidden: $('screenWin').classList.contains('hidden'),
  overHidden: $('screenOver').classList.contains('hidden'),
  nextSpawn: game.nextSpawnBeat, maxCombo: game.maxCombo,
  invincible: game.invincible, magnet: game.magnet, doubleT: game.doubleT,
  crouching: pl.crouching
});
globalThis.__step = (dt) => { if (AC) AC.__t += dt; demoThink(); update(dt); };
globalThis.__start = () => startGame();
globalThis.__hurt = () => damagePlayer();
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

class FakeOsc {
  constructor() { this.type = ''; this.frequency = { setValueAtTime() {}, exponentialRampToValueAtTime() {} }; }
  connect() {} start() {} stop() {}
}
class FakeNode {
  constructor() {
    this.gain = { value: 0, setValueAtTime() {}, linearRampToValueAtTime() {}, exponentialRampToValueAtTime() {} };
    this.frequency = { value: 0 };
  }
  connect() {}
}
class FakeAC {
  constructor() { this.__t = 0; this.sampleRate = 44100; this.destination = {}; this.state = 'running'; }
  get currentTime() { return this.__t; }
  createGain() { return new FakeNode(); }
  createOscillator() { return new FakeOsc(); }
  createBiquadFilter() { return new FakeNode(); }
  createBuffer() { return { getChannelData: () => new Float32Array(16) }; }
  createBufferSource() { return { buffer: null, connect() {}, start() {} }; }
  resume() { this.state = 'running'; }
  suspend() { this.state = 'suspended'; }
}
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
  Image: class {
    set src(v) { setTimeout(() => this.onload && this.onload(), 0); }
    onload = null;
  },
  requestAnimationFrame: () => 0,
  setInterval: () => 0,
  clearInterval: () => {},
  console, performance, setTimeout, clearTimeout,
};
vm.createContext(sandbox);
vm.runInContext(code, sandbox, { filename: 'game.js' });

const probe = () => vm.runInContext('__probe()', sandbox);
const step = (dt) => vm.runInContext('__step(' + dt + ')', sandbox);
const start = () => vm.runInContext('__start()', sandbox);
const hurt = () => vm.runInContext('__hurt()', sandbox);

const DT = 1 / 60;
let fail = 0;
const check = (name, cond, extra) => {
  if (!cond) { fail++; console.log('FAIL: ' + name + (extra ? ' | ' + JSON.stringify(extra) : '')); }
  else console.log('ok  : ' + name);
};

setTimeout(() => {
  console.log('--- 测试 1: 开始游戏 ---');
  start();
  let p = probe();
  check('模式为 running', p.mode === 'running', p);

  console.log('--- 测试 2: 跑酷 8 秒（机器人自动躲避） ---');
  for (let i = 0; i < 480; i++) step(DT);
  p = probe();
  check('音符已生成并收集', p.notesGot > 0, p);
  check('分数增长', p.score > 0, p);
  check('生命仍为 3（机器人躲避成功）', p.hearts === 3, p);
  check('仍在跑酷阶段', p.mode === 'running', p);

  console.log('--- 测试 3: 跑到 BOSS 战（5000 分或 120 秒） ---');
  let guard = 0;
  while (probe().mode === 'running' && guard < 9000) { step(DT); guard++; }
  p = probe();
  check('进入 BOSS 流程（bossintro/boss）', p.mode === 'bossintro' || p.mode === 'boss', p);
  // 等待 intro 结束进入 boss
  guard = 0;
  while (probe().mode === 'bossintro' && guard < 600) { step(DT); guard++; }
  p = probe();
  check('BOSS 战开始', p.mode === 'boss' && p.bossActive, p);
  check('BOSS 血量为满', p.bossHp === 10, p);

  console.log('--- 测试 4: 击败 BOSS ---');
  guard = 0;
  while (probe().mode === 'boss' && guard < 7200) { step(DT); guard++; }
  p = probe();
  check('取得胜利', p.mode === 'victory', p);
  check('BOSS 血量为 0', p.bossHp <= 0, p);
  check('玩家存活', p.hearts >= 1, p);
  setTimeout(() => {
    p = probe();
    check('胜利结算面板出现', p.winHidden === false, p);

    console.log('--- 测试 5: 受击与游戏结束 ---');
    start();
    step(DT); step(DT);
    hurt(); step(DT * 150); hurt(); step(DT * 150); hurt();
    p = probe();
    check('三次受击后游戏结束', p.mode === 'gameover', p);
    check('生命为 0', p.hearts === 0, p);

    console.log('--- 测试 6: 道具系统 ---');
    start(); step(DT);
    vm.runInContext('spawnItem();', sandbox);
    p = probe();
    check('道具已生成', p.items >= 1, p);
    vm.runInContext(`
      game.items = [];
      game.items.push({ x: pl.x - 23, y: pl.y - 56, w: 46, h: 48, kind: 'star', dead: false, t: 0 });
      collisions();
    `, sandbox);
    step(DT);
    p = probe();
    check('无敌道具收集后生效', p.invincible > 0, p);
    check('道具实体已消耗', p.items === 0, p);
    hurt();
    p = probe();
    check('无敌期间不掉血', p.hearts === 3, p);
    vm.runInContext('game.invincible = 0;', sandbox);
    hurt();
    p = probe();
    check('无敌结束后正常掉血', p.hearts === 2, p);
    vm.runInContext('game.invincible = 0; game.magnet = 0; game.doubleT = 0;', sandbox);

    console.log('--- 测试 7: 下蹲与屋顶障碍 ---');
    start(); step(DT);
    vm.runInContext(`
      pl.y = GROUND; pl.vy = 0; pl.crouching = false; pl.crouchBuf = 0;
      pl.invuln = 0; game.invuln = 0; game.invincible = 0;
      game.obstacles = [];
      game.obstacles.push({ x: pl.x - 20, y: 0, w: 72, h: GROUND - 50, kind: 'roof', dead: false });
      collisions();
    `, sandbox);
    p = probe();
    check('站立撞到屋顶会受伤', p.hearts === 2, p);
    vm.runInContext(`
      pl.invuln = 0; game.invuln = 0; game.invincible = 0;
      pl.crouching = true;
      game.obstacles = [];
      game.obstacles.push({ x: pl.x - 20, y: 0, w: 72, h: GROUND - 50, kind: 'roof', dead: false });
      collisions();
    `, sandbox);
    p = probe();
    check('蹲下通过屋顶不受伤', p.hearts === 2, p);
    check('下蹲状态生效', p.crouching === true, p);
    vm.runInContext(`
      pl.invuln = 0; game.invuln = 0; game.invincible = 0; pl.crouching = false;
      pl.crouchBuf = 0.1; pl.y = GROUND; pl.vy = 0; game.hitStop = 0;
      game.obstacles = []; game.nextSpawnBeat = 1e9;
    `, sandbox);
    step(DT);
    p = probe();
    check('下蹲缓冲可触发下蹲', p.crouching === true, p);
    vm.runInContext('pl.jumpBuf = 0.14;', sandbox);
    step(DT);
    p = probe();
    check('跳跃解除下蹲', p.crouching === false, p);
    vm.runInContext('game.invincible = 0; game.magnet = 0; game.doubleT = 0;', sandbox);
    hurt(); hurt(); hurt();
    setTimeout(() => {
      p = probe();
      check('失败结算面板出现', p.overHidden === false, p);
      console.log(fail === 0 ? '\n=== 全部通过 ===' : '\n=== 存在 ' + fail + ' 项失败 ===');
      process.exit(fail === 0 ? 0 : 1);
    }, 1200);
  }, 1800);
}, 30);
