# -*- coding: utf-8 -*-
"""纯色背景蓝键控：把垫蓝底的图转为透明 PNG（保留白色主体），并缩放进目标比例画布。"""
import math
from PIL import Image

BG = (0, 150, 255)
T1, T2 = 60, 120  # 完全透明 / 完全保留 的颜色距离阈值

def key_to_rgba(fin, fout, pad=4):
    im = Image.open(fin).convert('RGB')
    w, h = im.size
    px = im.load()
    out = Image.new('RGBA', (w, h), (0, 0, 0, 0))
    opx = out.load()
    for y in range(h):
        for x in range(w):
            r, g, b = px[x, y]
            d = math.sqrt((r - BG[0]) ** 2 + (g - BG[1]) ** 2 + (b - BG[2]) ** 2)
            if d >= T2:
                a = 1.0
            elif d <= T1:
                continue
            else:
                a = (d - T1) / (T2 - T1)
            if a < 0.2:
                continue
            t = a
            # 去背景色恢复前景色（抗蓝边）
            fr = (r - BG[0] * (1 - t)) / t
            fg = (g - BG[1] * (1 - t)) / t
            fb = (b - BG[2] * (1 - t)) / t
            opx[x, y] = (int(max(0, min(255, fr))), int(max(0, min(255, fg))),
                         int(max(0, min(255, fb))), int(255 * t))
    # 裁剪到主体
    bbox = out.getbbox()
    if bbox:
        x0, y0, x1, y1 = bbox
        out = out.crop((max(0, x0 - pad), max(0, y0 - pad), min(w, x1 + pad), min(h, y1 + pad)))
    out.save(fout)
    print(fout, out.size)
    return out.size

def place_on_canvas(src, dst, canvas_ratio, max_h=156):
    """把 src 透明图按真实比例缩放，放入宽:高=canvas_ratio 的画布中居中。"""
    im = Image.open(src)
    w, h = im.size
    ratio = w / h
    # 目标画布尺寸：高度 max_h 对应的整数
    cw = int(round(max_h * canvas_ratio))
    ch = max_h
    canvas = Image.new('RGBA', (cw, ch), (0, 0, 0, 0))
    # 角色缩放：占满高度，宽度按真实比例
    rh = ch
    rw = int(round(rh * ratio))
    if rw > cw:
        rw = cw
        rh = int(round(rw / ratio))
    im = im.resize((rw, rh), Image.LANCZOS)
    canvas.paste(im, ((cw - rw) // 2, (ch - rh) // 2), im)
    canvas.save(dst)
    print(dst, canvas.size, '角色', (rw, rh))

if __name__ == '__main__':
    d = r'D:/tangOvO1/learn/gugugaga快跑/_raw/3dview'
    key_to_rgba(d + '/doro_bluebg.png', d + '/doro_key.png')
    place_on_canvas(d + '/doro_key.png', d + '/doro_canvas.png', 150 / 156)
    key_to_rgba(d + '/peng_bluebg.png', d + '/peng_key.png')
    place_on_canvas(d + '/peng_key.png', d + '/peng_canvas.png', 86 / 96, max_h=96)
