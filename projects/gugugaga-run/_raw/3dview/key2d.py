# -*- coding: utf-8 -*-
"""下载 2D 重绘图，采样背景色，键控抠图，放入目标比例画布。"""
import math
import urllib.request
from PIL import Image

JOBS = [
    ('https://aka.doubaocdn.com/s/gB15dkPpTs', 'doro2d', 150 / 156, 156),
    ('https://aka.doubaocdn.com/s/ovrP7nqLiX', 'peng2d', 86 / 96, 96),
]
D = r'D:/tangOvO1/learn/gugugaga快跑/_raw/3dview'

def sample_bg(im):
    """取四角与四边中部像素的平均色作为背景色。"""
    w, h = im.size
    pts = [(8, 8), (w - 8, 8), (8, h - 8), (w - 8, h - 8),
           (w // 2, 8), (w // 2, h - 8), (8, h // 2), (w - 8, h // 2)]
    rs = gs = bs = 0
    n = 0
    for x, y in pts:
        r, g, b = im.getpixel((x, y))[:3]
        rs += r; gs += g; bs += b; n += 1
    return (rs / n, gs / n, bs / n)

def key(im, bg, T1=70, T2=140):
    """颜色距离键控：完全透明(<T1)、羽化(T1-T2)、保留(>T2)，并去背景色恢复边缘。"""
    w, h = im.size
    px = im.load()
    out = Image.new('RGBA', (w, h), (0, 0, 0, 0))
    opx = out.load()
    for y in range(h):
        for x in range(w):
            r, g, b = px[x, y][:3]
            d = math.sqrt((r - bg[0]) ** 2 + (g - bg[1]) ** 2 + (b - bg[2]) ** 2)
            if d >= T2:
                a = 1.0
            elif d <= T1:
                continue
            else:
                a = (d - T1) / (T2 - T1)
            if a < 0.2:
                continue
            t = a
            fr = (r - bg[0] * (1 - t)) / t
            fg = (g - bg[1] * (1 - t)) / t
            fb = (b - bg[2] * (1 - t)) / t
            opx[x, y] = (int(max(0, min(255, fr))), int(max(0, min(255, fg))),
                         int(max(0, min(255, fb))), int(255 * t))
    return out

def place(im, dst, canvas_ratio, max_h, pad=4):
    bbox = im.getbbox()
    if bbox:
        x0, y0, x1, y1 = bbox
        im = im.crop((max(0, x0 - pad), max(0, y0 - pad), min(im.size[0], x1 + pad), min(im.size[1], y1 + pad)))
    w, h = im.size
    ratio = w / h
    cw = int(round(max_h * canvas_ratio))
    ch = max_h
    canvas = Image.new('RGBA', (cw, ch), (0, 0, 0, 0))
    rh = ch
    rw = int(round(rh * ratio))
    if rw > cw:
        rw = cw
        rh = int(round(rw / ratio))
    im = im.resize((rw, rh), Image.LANCZOS)
    canvas.paste(im, ((cw - rw) // 2, (ch - rh) // 2), im)
    canvas.save(dst)
    print(dst, canvas.size, '角色', (rw, rh))

for url, name, cr, mh in JOBS:
    src = D + '/' + name + '.jpg'
    urllib.request.urlretrieve(url, src)
    im = Image.open(src).convert('RGBA')
    bg = sample_bg(im)
    print(name, 'bg=', tuple(round(v, 1) for v in bg), 'size', im.size)
    cut = key(im, bg)
    cut.save(D + '/' + name + '_cut.png')
    place(cut, D + '/' + name + '_canvas.png', cr, mh)
