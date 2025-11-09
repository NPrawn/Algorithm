n, k = map(int, input().split())
items = [list(map(int, input().split())) for _ in range(n)]
dp = [0 for _ in range(k+1)]
for w, v in items:
	for j in range(k, w-1, -1):
		dp[j] = max(dp[j], dp[j-w] + v)

print(dp[k])