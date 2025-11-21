T = int(input())
for tc in range(1, T+1):
	n, m = map(int, input().split())
	grid = [list(input()) for _ in range(n)]
	dirs = [[1,0],[0,1],[-1,0],[0,-1]]
	x,y,d = 0,0,0
	
	def in_range(nx,ny):
		return not (0 <= nx < n and 0 <= ny < m)
	
	for i in range(n):
		for j in range(m):
			if grid[i][j]=='<' or grid[i][j]=='>' or grid[i][j]=='^' or grid[i][j]=='v':
				x,y = i,j
			if grid[i][j]=='<': d=3
			if grid[i][j]=='>': d=1
			if grid[i][j]=='^': d=2
			if grid[i][j]=='v': d=0
	
	k = int(input())
	cmd = list(input())
	for c in cmd:
		if c=='S':
			sx, sy = x, y
			dx, dy = dirs[d]
			while True:
				nx, ny = sx+dx, sy+dy
				if in_range(nx,ny): break
				if grid[nx][ny] == '*':
					grid[nx][ny] = '.'
					break
				if grid[nx][ny] == '#': break
				sx, sy = nx, ny
		if c=='U':
			d=2
			grid[x][y] = '^'
			dx, dy = dirs[d]
			nx,ny = x+dx, y+dy
			if in_range(nx,ny): continue
			if grid[nx][ny] == '.':
				grid[nx][ny] = '^'
				grid[x][y] = '.'
				x,y = nx,ny
		if c=='D':
			d=0
			grid[x][y] = 'v'
			dx, dy = dirs[d]
			nx,ny = x+dx, y+dy
			if in_range(nx,ny): continue
			if grid[nx][ny] == '.':
				grid[nx][ny] = 'v'
				grid[x][y] = '.'
				x, y = nx, ny
		if c=='L':
			d=3
			grid[x][y] = '<'
			dx, dy = dirs[d]
			nx,ny = x+dx, y+dy
			if in_range(nx,ny): continue
			if grid[nx][ny] == '.':
				grid[nx][ny] = '<'
				grid[x][y] = '.'
				x, y = nx, ny
		if c=='R':
			d=1
			grid[x][y] = '>'
			dx, dy = dirs[d]
			nx,ny = x+dx, y+dy
			if in_range(nx,ny): continue
			if grid[nx][ny] == '.':
				grid[nx][ny] = '>'
				grid[x][y] = '.'
				x, y = nx, ny
	
	print(f'#{tc}', end=' ')
	for i in range(n):
		for j in range(m):
			print(grid[i][j], end='')
		print()