from collections import deque

n = int(input())
grid = [[0 for _ in range(105)] for _ in range(105)]
for _ in range(n):
	a, b = map(int, input().split())
	grid[a][b] = 1

ans = 0
vis = [[0 for _ in range(105)] for _ in range(105)]
q = deque()
q.append([0,0])
while q:
	x, y = q.popleft()
	if vis[x][y]: continue
	vis[x][y]=1
	for dx, dy in [[1,0],[0,1],[-1,0],[0,-1]]:
		nx, ny = x+dx, y+dy
		if not (0<=nx<105 and 0<=ny<105): continue
		if grid[nx][ny]==1: ans+=1; continue
		if vis[nx][ny]: continue
		q.append([nx,ny])
print(ans)