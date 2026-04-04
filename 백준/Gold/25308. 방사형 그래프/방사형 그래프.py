from itertools import permutations
import math

SQRT2 = math.sqrt(2.0)

def cross(ax, ay, bx, by):
    return ax*by - ay*bx

def check(a, b, c):
    ax, ay = a / SQRT2, -a /SQRT2
    bx, by = b, 0.0
    cx, cy = c / SQRT2, c / SQRT2
    ox, oy = 0.0, 0.0

    ux, uy = ax - bx, ay - by
    vx, vy = cx - bx, cy - by
    wx, wy = ox - bx, oy - by

    uv = cross(ux, uy, vx, vy)

    if abs(uv) <= 1e-12:
        return False

    if uv < 0:
        ux, uy, vx, vy = vx, vy, ux, uy

    res = (cross(ux,uy,wx,wy) >= 1e-12) and (cross(wx,wy,vx,vy) >= 1e-12)
    return not res

arr = map(int, input().split())
ans = 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1

for lst in permutations(arr, 8):
    for now in range(8):
        pre = now - 1
        nxt = now + 1
        if pre < 0: pre = 7
        if nxt > 7: nxt = 0

        a = lst[pre]
        b = lst[now]
        c = lst[nxt]
        if check(a,b,c):
            ans -= 1
            break

print(ans)
