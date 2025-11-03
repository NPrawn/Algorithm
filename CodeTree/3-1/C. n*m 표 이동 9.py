from collections import deque

n, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]
dist = [[[-1,-1] for _ in range(m)] for _ in range(n)]
q = deque()
if grid[0][0] == 1:
	q.append([0,0,1])
	dist[0][0][1] = 1
else:
	q.append([0,0,0])
	dist[0][0][0] = 1

dxdy = [[1,0],[0,1],[-1,0],[0,-1]]

while q:
	x, y, z = q.popleft()
	for dx, dy in dxdy:
		nx, ny = x+dx, y+dy
		if not (0<=nx<n and 0<=ny<m): continue
		if dist[nx][ny][z] != -1: continue
		if grid[nx][ny] == 1 and z==0:
			dist[nx][ny][1] = dist[x][y][z] + 1
			q.append([nx,ny,1])
			continue
		if grid[nx][ny] == 1: continue
		q.append([nx,ny,z])
		dist[nx][ny][z] = dist[x][y][z] + 1

ans = dist[n-1][m-1]
if ans[0] == -1:
	print(ans[1])
elif ans[1] == -1:
	print(ans[0])
else:
	print(min(ans))

# print(ans[0] if ans[0]!=-1 else ans[1])