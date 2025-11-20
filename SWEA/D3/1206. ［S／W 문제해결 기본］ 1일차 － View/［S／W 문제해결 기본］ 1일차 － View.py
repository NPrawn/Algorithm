T = 10
for tc in range(1, T+1):
	n = int(input())
	grid = [[0 for _ in range(260)] for _ in range(1005)]
	arr = list(map(int, input().split()))
	for i, a in enumerate(arr):
		for j in range(a):
			grid[i][j] = 1
	
	ans = 0
	for i in range(1005):
		for j in range(260):
			if grid[i][j]==0: continue
			if grid[i-1][j]==0 and grid[i-2][j]==0 and grid[i+1][j]==0 and grid[i+2][j]==0: ans+=1
	
	print(f'#{tc} {ans}')