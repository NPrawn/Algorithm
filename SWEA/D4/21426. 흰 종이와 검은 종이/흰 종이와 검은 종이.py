def area(x1,y1,x2,y2):
    w = max(0, min(x2[0], x2[1]) - max(x1[0], x1[1]))
    h = max(0, min(y2[0], y2[1]) - max(y1[0], y1[1]))
    return w * h

def inter(r1, r2):
    x1 = max(r1[0], r2[0])
    y1 = max(r1[1], r2[1])
    x2 = min(r1[2], r2[2])
    y2 = min(r1[3], r2[3])
    if x1 >= x2 or y1 >= y2:
        return None
    return (x1, y1, x2, y2)

T = int(input().strip())
ans = []
for _ in range(T):
    wx1, wy1, wx2, wy2 = map(int, input().split())
    b1x1, b1y1, b1x2, b1y2 = map(int, input().split())
    b2x1, b2y1, b2x2, b2y2 = map(int, input().split())

    W  = (wx1, wy1, wx2, wy2)
    B1 = (b1x1, b1y1, b1x2, b1y2)
    B2 = (b2x1, b2y1, b2x2, b2y2)

    A_W  = (wx2 - wx1) * (wy2 - wy1)

    W_B1 = inter(W, B1)
    W_B2 = inter(W, B2)
    cov  = 0
    if W_B1: cov += (W_B1[2]-W_B1[0]) * (W_B1[3]-W_B1[1])
    if W_B2: cov += (W_B2[2]-W_B2[0]) * (W_B2[3]-W_B2[1])

    W_B1_B2 = None
    if W_B1 and W_B2:
        W_B1_B2 = inter(W_B1, W_B2)
    if W_B1_B2:
        cov -= (W_B1_B2[2]-W_B1_B2[0]) * (W_B1_B2[3]-W_B1_B2[1])

    ans.append("YES" if A_W - cov > 0 else "NO")

print("\n".join(ans))
