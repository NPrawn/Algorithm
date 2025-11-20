from collections import deque

T = int(input())
for tc in range(1, T+1):
	n = int(input())
	grid = [list(map(int, input())) for _ in range(n)]
	x, y = n//2, n//2
	dist = [[-1 for _ in range(n)] for _ in range(n)]
	dist[x][y] = 0
	q = deque()
	q.append((x,y))
	ans = 0
	while q:
		x, y = q.popleft()
		ans += grid[x][y]
		if dist[x][y] == n//2: continue
		for dx, dy in [[1,0],[0,1],[-1,0],[0,-1]]:
			nx, ny = x+dx, y+dy
			if not (0<=nx<n and 0<=ny<n): continue
			if dist[nx][ny] != -1: continue
			dist[nx][ny] = dist[x][y] + 1
			q.append((nx,ny))
	
	print(f'#{tc} {ans}')