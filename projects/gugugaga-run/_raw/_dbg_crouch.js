const fs = require('fs');
const vm = require('vm');
const html = fs.readFileSync('D:/tangOvO1/learn/gugugaga快跑/index.html', 'utf8');
const m = html.match(/<script>([\s\S]*?)<\/script>/);
let code = m[1];
code += `
globalThis.__probe = () => ({ crouching: pl.crouching, crouchBuf: pl.crouchBuf, jumpBuf: pl.jumpBuf, grounded: pl.grounded, y: pl.y, jumps: pl.jumps, t: Math.round(game.t*100)/100 });
globalThis.__step = (dt) => { demoThink(); update(dt); };
globalThis.__start = () => startGame();
`;
function makeEl(id) {
  const cls = new Set();
  return { id, textContent: '', innerHTML: '', disabled: false, offsetWidth: 100, style: {}, width: 0, height: 0,
    classList: { add: c => cls.add(c), remove: c => cls.delete(c), contains: c => cls.has(c), toggle: () => {} } };
}
const sandbox = {
  console, Math, JSON, Date, performance: { now: () => Date.now() },
  requestAnimationFrame: () => {}, addEventListener: () => {}, removeEventListener: () => {},
  Image: function () { this.addEventListener = () => {}; this.setAttribute = () => {}; },
  Audio: function () { this.play = () => {}; this.addEventListener = () => {}; },
  document: { getElementById: makeEl, querySelector: () => makeEl('x'), createElement: () => makeEl('x'), addEventListener: () => {}, body: { appendChild: () => {} } },
  window: {}, localStorage: { getItem: () => null, setItem: () => {} }, alert: () => {}, setTimeout, clearTimeout,
  globalThis: null
};
sandbox.globalThis = sandbox;
vm.createContext(sandbox);
vm.runInContext(code, sandbox);
const step = (dt) => vm.runInContext('__step(' + dt + ')', sandbox);
const probe = () => vm.runInContext('__probe()', sandbox);
const DT = 1 / 60;
vm.runInContext('__start()', sandbox);
step(DT);
vm.runInContext(`
  pl.y = GROUND; pl.vy = 0; pl.crouching = false; pl.crouchBuf = 0;
  pl.invuln = 0; game.invuln = 0; game.invincible = 0;
  game.obstacles = [];
  game.obstacles.push({ x: pl.x - 20, y: 0, w: 72, h: GROUND - 50, kind: 'roof', dead: false });
  collisions();
`, sandbox);
step(DT);
vm.runInContext(`
  pl.invuln = 0; game.invuln = 0; game.invincible = 0; pl.crouching = false;
  pl.crouchBuf = 0.1; pl.y = GROUND; pl.vy = 0; game.hitStop = 0;
`, sandbox);
step(DT);
console.log('after crouchBuf step:', JSON.stringify(probe()));
vm.runInContext('pl.jumpBuf = 0.14;', sandbox);
step(DT);
console.log('after jumpBuf step:', JSON.stringify(probe()));
