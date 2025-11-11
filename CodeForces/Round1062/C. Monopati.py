T = int(input())
ans = []

for _ in range(T):
	n = int(input())
	grid = [list(map(int, input().split())) for _ in range(2)]
	dp = [[[0,0] for _ in range(n)] for _ in range(2)]
	mn = float('inf')
	mx = float('inf')
	for i in range(n):
		if mn > grid[0][i]:
			mn = grid[0][i]
			dp[0][i][0] = mn
		if mx < grid[0][i]:
			mx = grid[1][i]
			dp[0][i][1] = mx
			
	mn = float('inf')
	mx = float('inf')
	for i in range(n-1,-1,-1):
		if mn > grid[1][i]:
			mn = grid[1][i]
			dp[1][i][0] = mn
		if mx < grid[1][i]:
			mx = grid[1][i]
			dp[1][i][1] = mx

	mns = []
	mxs = []
	for i in range(n):
		mn = min(dp[0][i][0], dp[1])
	
	ct = 0
	a = max(mns)
	b = min(mxs)
	ct += a * (2 * n - b + 1)
	ans.append(ct)
for e in ans:
	print(e)