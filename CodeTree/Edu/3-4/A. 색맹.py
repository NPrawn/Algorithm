from collections import deque

n = int(input())
ans = []
grid = [list(input()) for _ in range(n)]

def bfs() -> int:
	dist = [[0 for _ in range(n)] for _ in range(n)]
	q = deque()
	idx = 0
	for i in range(n):
		for j in range(n):
			if dist[i][j] != 0: continue
			idx += 1
			color = grid[i][j]
			q.append([i, j])
			dist[i][j] = idx
			while q:
				x, y = q.popleft()
				for dx, dy in [[1, 0], [0, 1], [-1, 0], [0, -1]]:
					nx, ny = x + dx, y + dy
					if not (0 <= nx < n and 0 <= ny < n): continue
					if dist[nx][ny] != 0: continue
					if grid[nx][ny] != color: continue
					q.append([nx, ny])
					dist[nx][ny] = idx
	return idx

ans1 = bfs()
for i in range(n):
	for j in range(n):
		if grid[i][j]=='R':
			grid[i][j]='G'
ans2 = bfs()

print(ans1, ans2)