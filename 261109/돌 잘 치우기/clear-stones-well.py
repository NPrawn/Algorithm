from itertools import combinations
from collections import deque

n, k, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]
starts = [[int(x) - 1 for x in input().split()] for _ in range(k)]
stones = []
dxs = [1,0,-1,0]
dys = [0,1,0,-1]
ans = 0

for x in range(n):
    for y in range(n):
        if grid[x][y] == 1:
            stones.append((x,y))

for comb in combinations(stones, m):
    for x, y in comb:
        grid[x][y] = 0
    
    q = deque()
    visited = [[0 for _ in range(n)] for _ in range(n)]
    res = 0
    for s in starts:
        q.append(s)
        res += 1
        visited[s[0]][s[1]] = 1

    while q:
        x, y = q.popleft()
        for dx, dy in zip(dxs, dys):
            nx = x + dx
            ny = y + dy
            if not (0 <= nx < n and 0 <= ny < n): continue
            if visited[nx][ny] == 1: continue
            if grid[nx][ny] == 1: continue
            visited[nx][ny] = 1
            res += 1
            q.append((nx,ny))
    
    ans = max(res, ans)

    for x, y in comb:
        grid[x][y] = 1

print(ans)