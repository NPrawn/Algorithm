n = int(input())
pairs = []
for _ in range(n):
	a, b = map(int, input().split())
	pairs.append([a, b])
dp = [[[0 for _ in range(16)] for _ in range(16)] for _ in range(n+1)]

for i in range(n):
	a, b = pairs[i]
	for l in range(16):
		for r in range(16):
			cur = dp[i][l][r]
			dp[i+1][l][r] = max(dp[i+1][l][r], cur)
			if l < 15:
				dp[i+1][l+1][r] = max(dp[i+1][l+1][r], cur + a)
			if r < 15:
				dp[i+1][l][r+1] = max(dp[i+1][l][r+1], cur + b)

print(dp[n][15][15])