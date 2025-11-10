from collections import deque

m, n = map(int, input().split())
grid = [list(map(int, input())) for _ in range(n)]
dxdy = [[1,0],[0,1],[-1,0],[0,-1]]
d = [[-1 for _ in range(m)] for _ in range(n)]
q = deque()
q.append([0,0])
d[0][0] = 0
while q:
	x, y = q.popleft()
	for dx, dy in dxdy:
		nx, ny = x+dx, y+dy
		if not (0<=nx<n and 0<=ny<m): continue
		if d[nx][ny] != -1: continue
		if grid[nx][ny] == 1:
			d[nx][ny] = d[x][y]+1
			q.append([nx,ny])
		else:
			d[nx][ny] = d[x][y]
			q.appendleft([nx,ny])

print(d[n-1][m-1])