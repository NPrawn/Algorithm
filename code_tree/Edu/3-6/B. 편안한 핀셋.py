from collections import deque

n = int(input())
grid = [[0 for _ in range(1005)] for _ in range(1005)]
ans = []
res = 0
for _ in range(n):
	x, y = map(int, input().split())
	grid[x][y] = 1
	q = deque()
	ct = 0
	for dx,dy in [[1,0],[0,1],[-1,0],[0,-1]]:
		nx, ny = x + dx, y + dy
		if not (0 <= nx < 1005 and 0 <= ny < 1005): continue
		if grid[nx][ny] == 1:
			ct+=1
			q.append([nx,ny])
		if ct==3: res+=1
	while q:
		x, y = q.popleft()
		ct = 0
		for dx, dy in [[1, 0], [0, 1], [-1, 0], [0, -1]]:
			nx,ny = x+dx, y+dy
			if not (0<=nx<1005 and 0<=ny<1005): continue
			if grid[nx][ny]==1: ct+=1
		if ct==3: res+=1
		if ct==4: res-=1
	ans.append(res)

for e in ans:
	print(e)