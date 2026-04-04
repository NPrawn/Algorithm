from collections import deque

n = int(input())
grid = [list(map(int, input().split())) for _ in range(n)]
visited = [[0 for _ in range(n)] for _ in range(n)]
dxdy = [[1,0],[0,1],[-1,0],[0,-1]]
ans = []
q = deque()

for i in range(n):
	for j in range(n):
		if grid[i][j] == 0: continue
		if visited[i][j]: continue
		q.append([i,j])
		visited[i][j] = 1
		ct = 1
		while q:
			x, y = q.popleft()
			for dx,dy in dxdy:
				nx, ny = x+dx, y+dy
				if not (0<=nx<n and 0<=ny<n): continue
				if visited[nx][ny]: continue
				if grid[nx][ny] == 0: continue
				q.append([nx,ny])
				visited[nx][ny] = 1
				ct+=1
		ans.append(ct)

ans.sort()
print(len(ans))
for e in ans:
	print(e)