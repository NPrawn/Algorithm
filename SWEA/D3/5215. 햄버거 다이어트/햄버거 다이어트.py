T = int(input())
for tc in range(1, T+1):
	n, k = map(int, input().split())
	dp = [[0 for _ in range(k+1)] for _ in range(n+1)]
	for i in range(1, n+1):
		v, w = map(int, input().split())
		for j in range(k):
			if j-w >= 0:
				dp[i][j] = dp[i-1][j-w] + v
			dp[i][j] = max(dp[i-1][j], dp[i][j])
	
	print(f'#{tc} {max(dp[-1])}')