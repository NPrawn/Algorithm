from collections import deque

n, m = map(int, input().split())
grid = [list(input()) for _ in range(n)]
vis = [[0 for _ in range(m)] for _ in range(n)]
dir = {'L': [0, -1], 'R': [0, 1], 'D': [1, 0], 'U': [-1, 0]}
idx = 0
ans = []

for x in range(n):
    for y in range(m):
        if vis[x][y] >= 1: continue
        idx+=1
        q = deque()
        q.append([x,y])
        vis[x][y] = idx

        while q:
            curX, curY = q.popleft()
            dx, dy = dir[grid[curX][curY]]
            nx, ny = curX+dx, curY+dy
            if vis[nx][ny] >= 1:
                if vis[nx][ny] == idx:
                    ans.append([nx,ny])
                continue
            vis[nx][ny] = idx
            q.append([nx,ny])

print(len(ans))