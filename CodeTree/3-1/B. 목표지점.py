from collections import deque

n, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]
dist = [[-1 for _ in range(m)] for _ in range(n)]
q = deque()

for i in range(n):
	for j in range(m):
		if grid[i][j]==2:
			q.append([i,j])
			dist[i][j] = 0
			break
	if q: break

dxdy = [[1,0],[0,1],[-1,0],[0,-1]]
while q:
	x, y = q.popleft()
	for dx, dy in dxdy:
		nx, ny = x+dx, y+dy
		if not (0<=nx<n and 0<=ny<m): continue
		if grid[nx][ny] == 0: continue
		if dist[nx][ny] != -1: continue
		dist[nx][ny] = dist[x][y] + 1
		q.append([nx,ny])

for i in range(n):
	for j in range(m):
		if grid[i][j] == 0:
			dist[i][j] = grid[i][j] = 0

for e in dist:
	print(*e)