from collections import deque

N = int(input())
grid = [list(input()) for _ in range(N)]
q = deque()
buffer = []
vis = [[-1 for _ in range(N)] for _ in range(N)]
for i in range(N):
    for j in range(N):
        if grid[i][j] == 'R':
            q = {(i,j)}
            vis[i][j] = 0
        if grid[i][j] == 'K':
            kx, ky = i, j

def in_range(x,y):
    return 0<=x<N and 0<=y<N
dxdy = [(1,0),(-1,0),(0,1),(0,-1)]

while q:
    next_q = set()

    for x, y in q:
        for dx, dy in dxdy:
            nx = x+dx
            ny = y+dy
            while in_range(nx, ny):
                if vis[nx][ny] != -1: break
                if grid[nx][ny]=='B': break
                next_q.add((nx,ny))
                if grid[nx][ny]=='W': break

                nx += dx
                ny += dy
    
    for i, j in next_q:
        vis[i][j] = vis[x][y]+1
    q = next_q

print(vis[kx][ky])