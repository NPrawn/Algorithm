n = int(input())
grid = [list(map(int, input().split())) for _ in range(n)]
dp = [[0]*n for _ in range(n)]

for row in grid:
    while len(row)<n: row.append(0)

dp[0][0] = grid[0][0]
for i in range(1, n):
    dp[i][0] = dp[i-1][0] + grid[i][0]
for i in range(1, n):
    for j in range(1, n):
        dp[i][j] = max(dp[i-1][j-1], dp[i-1][j]) + grid[i][j]

print(max(dp[n-1]))