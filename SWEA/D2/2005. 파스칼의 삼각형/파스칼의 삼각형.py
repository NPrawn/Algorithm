T = int(input())
for tc in range(1, T+1):
	n = int(input())
	grid = [[0 for _ in range(n)] for _ in range(n)]
	grid[0][0] = 1
	for i in range(n):
		grid[i][0] = 1
	for i in range(1, n):
		for j in range(1, n):
			grid[i][j] = grid[i-1][j] + grid[i-1][j-1]
	
	print(f'#{tc}')
	for i in range(n):
		for j in range(n):
			if grid[i][j]==0: continue
			print(grid[i][j], end=' ')
		print()