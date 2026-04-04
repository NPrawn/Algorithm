n, m = map(int, input().split())
dp = [[0 for _ in range(m+1)] for _ in range(n+1)]
MOD = 1000000007
for i in range(1, m+1):
	dp[0][i] = 1

for i in range(1, n+1):
	for j in range(1, m+1):
		dp[i][j] = sum(dp[i-1][:j//2+1])%MOD

print(sum(dp[n-1])%MOD)