n, K = map(int, input().split())
d = [list(map(int, input().split())) for _ in range(n)]
inf = float('inf')

for k in range(n):
	for i in range(n):
		for j in range(n):
			if d[i][j]>d[i][k]+d[k][j]:
				d[i][j] = d[i][k]+d[k][j]

full = (1 << n ) - 1
dp = [[inf for _ in range(n)] for _ in range(1<<n)]
dp[1<<K][K] = 0

for mask in range(1 << n):
	for u in range(n):
		if dp[mask][u] == inf: continue
		for v in range(n):
			nmask = mask | (1 << v)
			cost = dp[mask][u] + d[u][v]
			if dp[nmask][v] > cost:
				dp[nmask][v] = cost

print(min(dp[full]))