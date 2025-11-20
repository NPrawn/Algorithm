import heapq

inf = float('inf')
T = int(input())
for tc in range(1, T+1):
	n = int(input())
	grid = [list(map(int, input())) for _ in range(n)]
	dist = [[inf for _ in range(n)] for _ in range(n)]
	pq = []
	heapq.heappush(pq, (0,0,0))
	dist[0][0] = 0
	while pq:
		cost, x, y = heapq.heappop(pq)
		
		if dist[x][y] != cost: continue
		for dx, dy in [[1,0],[0,1],[-1,0],[0,-1]]:
			nx,ny = x+dx, y+dy
			if not (0<=nx<n and 0<=ny<n): continue
			if dist[nx][ny] <= dist[x][y]+grid[nx][ny]: continue
			dist[nx][ny] = dist[x][y]+grid[nx][ny]
			heapq.heappush(pq, (dist[nx][ny], nx, ny))
	
	print(f'#{tc} {dist[n - 1][n - 1]}')
