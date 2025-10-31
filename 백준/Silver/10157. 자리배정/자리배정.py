from collections import deque

c, r = map(int, input().split())
k = int(input())
dist = [[0 for _ in range(c)] for _ in range(r)]
dxdy = [[1,0],[0,1],[-1,0],[0,-1]]

x,y,d = 0,0,0
dist[x][y] = 1
for i in range(c*r-1):
	dx, dy = dxdy[d]
	nx, ny = x+dx, y+dy
	if not (0<=nx<r and 0<=ny<c) or dist[nx][ny] != 0:
		d+=1
		d%=4
		dx, dy = dxdy[d]
		nx, ny = x + dx, y + dy
	dist[nx][ny] = dist[x][y]+1
	x,y = nx, ny

ans = []
for i in range(r):
	for j in range(c):
		if dist[i][j]==k:
			ans = [j+1,i+1]

if r*c>=k:
	print(*ans)
else:
	print(0)