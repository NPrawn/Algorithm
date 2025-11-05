from collections import deque

n, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]
sizes = [0]
q = deque()
dist = [[0 for _ in range(m)] for _ in range(n)]
idx = 1
dxdy = [[1,0],[0,1],[-1,0],[0,-1]]
for i in range(n):
	for j in range(m):
		if grid[i][j] == 0: continue
		if dist[i][j] != 0: continue
		q.append([i, j])
		dist[i][j] = idx
		ct = 1
		while q:
			x, y = q.popleft()
			for dx, dy in dxdy:
				nx, ny = x+dx, y+dy
				if not (0<=nx<n and 0<=ny<m): continue
				if grid[nx][ny] == 0: continue
				if dist[nx][ny] != 0: continue
				dist[nx][ny] = idx
				q.append([nx, ny])
				ct+=1
		
		sizes.append(ct)
		idx+=1

ans = 0
for x in range(n):
	for y in range(m):
		if dist[x][y] != 0: continue
		s = set()
		for dx,dy in dxdy:
			nx, ny = x+dx, y+dy
			if not (0 <= nx < n and 0 <= ny < m): continue
			if dist[nx][ny] == 0: continue
			s.add(dist[nx][ny])
		ct = 1
		for a in s:
			ct += sizes[a]
		ans = max(ans, ct)
		
print(ans)