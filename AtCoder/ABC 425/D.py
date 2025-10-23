from collections import deque

h, w = map(int, input().split())
grid = [list(input()) for _ in range(h)]

dxdy = [(1,0), (0,1), (-1,0), (0,-1)]

def in_grid(x, y):
    return 0<=x<h and 0<=y<w

def count(x, y):
    c = 0
    for dx, dy in dxdy:
        nx, ny = x+dx, y+dy
        if in_grid(nx,ny) and grid[nx][ny]=='#':
            c+=1
    return c

stk = []
for x in range(h):
    for y in range(w):
        if grid[x][y] == '.' and count(x, y)==1:
            stk.append((x,y))

while True:
    if len(stk)==0: break
    for x,y in stk:
        grid[x][y] = '#'

    nstk = []
    for x, y in stk:
        for dx, dy in dxdy:
            nx, ny = x+dx, y+dy
            if in_grid(nx,ny) and grid[nx][ny]=='.' and count(nx,ny) == 1:
                nstk.append((nx,ny))
    stk = nstk


ans = 0
for row in grid:
    ans += row.count('#')
print(ans)