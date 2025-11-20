T = int(input())
for tc in range(1, T+1):
	n = int(input())
	grid = [[0 for _ in range(n)] for _ in range(n)]
	dirs = [[0,1],[1,0],[0,-1],[-1,0]]
	d = 0
	grid[0][0] = 1
	x, y = 0,0
	for i in range(n*n-1):
		dx, dy = dirs[d]
		nx, ny = x+dx, y+dy
		if not (0<=nx<n and 0<=ny<n) or grid[nx][ny] != 0:
			d+=1
			d%=4
			dx, dy = dirs[d]
			nx, ny = x + dx, y + dy
			
		grid[nx][ny] = grid[x][y]+1
		x,y=nx,ny
	print(f'#{tc}')
	for e in grid:
		print(*e)