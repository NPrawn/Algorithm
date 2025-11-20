for _ in range(10):
	tc = int(input())
	grid =[list(map(int, input().split())) for _ in range(100)]
	x, y = 0, 0
	vis = [[0 for _ in range(100)] for _ in range(100)]
	for i in range(100):
		if grid[99][i]==2:
			x=99
			y=i
	vis[x][y] = 1
	while True:
		if x==0: break
		if 0<y<100 and grid[x][y-1]==1 and vis[x][y-1]==0:
			x, y = x, y-1
		elif 0<=y<99 and grid[x][y+1]==1 and vis[x][y+1]==0:
			x, y = x,y+1
		else:
			x,y = x-1,y
		vis[x][y] = 1
	
	print(f'#{tc} {y}')