T = int(input())
ans = []
for tc in range(T):
	n = int(input())
	grid = [[0 for _ in range(n+2)] for _ in range(n+2)]
	for i in range(1, n+1):
		for j in range(1, n+1):
			grid[i][j] = (i-1)*n + j
	mx = -1
	for i in range(1, n+1):
		for j in range(1, n+1):
			mx = max(mx, grid[i][j]+grid[i-1][j]+grid[i+1][j]+grid[i][j-1]+grid[i][j+1])
	ans.append(mx)

for e in ans:
	print(e)