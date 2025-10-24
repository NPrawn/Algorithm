T = int(input())
ans = []
for _ in range(T):
    n = int(input())
    grid = [list(map(int, input().split()))]
    grid.append(list(map(int, input().split())))
    dp = [[[0, 0] for _ in range(n)] for _ in range(2)]
    dp[0][0][1] = grid[0][0]
    dp[1][0][1] = grid[1][0]
    for j in range(1, n):
        for i in range(2):
            dp[i][j][0] = max(dp[0][j-1][0], dp[0][j-1][1], dp[1][j-1][0], dp[1][j-1][1])
            k = dp[1][j-1][1] if i==0 else dp[0][j-1][1]
            dp[i][j][1] = max(dp[0][j-1][0], dp[1][j-1][0], k)+grid[i][j]
    mx = 0
    for i in range(2):
        for j in range(n):
            mx = max(mx, max(dp[i][j]))
    ans.append(mx)

for e in ans:
    print(e)