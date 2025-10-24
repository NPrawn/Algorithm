ans = []
while True:
    n = int(input())
    if n==0: break
    grid = [list(map(int, input().split())) for _ in range(n)]
    dp = [[0 for _ in range(3)] for _ in range(n)]
    dp[0][0] = float('inf')
    dp[0][1] = grid[0][1]
    dp[0][2] = grid[0][1] + grid[0][2]
    
    for i in range(1, n):
        dp[i][0] = min(dp[i-1][0], dp[i-1][1]) + grid[i][0]
        dp[i][1] = min(min(dp[i-1]), dp[i][0]) + grid[i][1]
        dp[i][2] = min(min(dp[i-1][1:]), dp[i][1]) + grid[i][2]
    ans.append(dp[n-1][1])

for i,v in enumerate(ans):
    print(f"{i+1}. {v}")