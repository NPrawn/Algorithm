from collections import deque

h, w = map(int, input().split())
a = [list(input()) for _ in range(h)]
ans = []

px = py = -1
for i in range(h):
    for j in range(w):
        if a[i][j]=='T': px, py = i, j

s = [[0] * (w+1) for _ in range(h+1)]
for i in range(h):
    row = s[i]
    row1 = s[i+1]
    for j in range(w):
        row1[j+1] = row1[j] + s[i][j+1] - s[i][j] + (1 if a[i][j]=='#' else 0)

def rect_has_hash(lx, rx, ly, ry):
    return (s[rx][ry] + s[lx][ly] - s[lx][ry] - s[rx][ly]) != 0

start = (0,h,0,w,h,w)
dist = {start: 0}
q = deque([start])

while q:
    lx, rx, ly, ry, xx, yy = q.popleft()
    curd = dist[(lx,rx,ly,ry,xx,yy)]

    if not rect_has_hash(lx,rx,ly,ry):
        ans.append(curd)
        break

    for dx, dy in ((1,0), (-1,0), (0,1), (0,-1)):
        nxx = xx+dx
        nyy = yy+dy
        nlx, nrx, nly, nry = lx,rx,ly,ry

        if nxx - h > nlx: nlx = nxx - h
        if nxx<nrx: nrx = nxx
        if nyy - w > nly: nly = nyy - w
        if nyy<nry: nry = nyy

        if nxx < 0 or nxx > 2*h or nyy<0 or nyy>2*w: continue

        X = px + nxx - h
        Y = py + nyy - w
        blocked = (nlx<=X<nrx and nly <=Y<nry and a[X][Y]=='#')
        next = (nlx,nrx,nly,nry,nxx,nyy)
        if not blocked and next not in dist:
            dist[next] = curd+1
            q.append(next)

print(ans[0] if ans else -1)