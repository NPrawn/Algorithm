from collections import deque

n = int(input())
grid = [list(map(int, input().split())) for _ in range(n)]
dp = [[0 for _ in range(n)] for _ in range(n)]
if grid[0][0] == 0: dp[0][0] = 1
for i in range(1, n):
	if grid[i][0] == dp[i-1][0] % 3:
		dp[i][0] = dp[i-1][0] + 1
	else:
		dp[i][0] = dp[i-1][0]
		
	if grid[0][i] == dp[0][i-1] % 3:
		dp[0][i] = dp[0][i-1] + 1
	else:
		dp[0][i] = dp[0][i-1]

for i in range(1, n):
	for j in range(1, n):
		if grid[i][j] == dp[i-1][j]%3:
			dp[i][j] = dp[i-1][j] + 1
		else:
			dp[i][j] = dp[i-1][j]
		if grid[i][j] == dp[i][j-1]%3:
			dp[i][j] = max(dp[i][j-1]+1,dp[i][j])
		else:
			dp[i][j] = max(dp[i][j - 1], dp[i][j])

print(dp[n-1][n-1])