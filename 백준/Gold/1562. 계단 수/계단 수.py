n = int(input())
dp = [[[0, 0, 0, 0] for _ in range(10)] for _ in range(n+1)]
mod = 1000000000

for num in range(1, 10):
    if num==9:
        dp[1][num][1] = 1
    else:
        dp[1][num][3] = 1

for i in range(2, n+1):
    for num in range(10):
        if num == 0:
            dp[i][num][2] = (dp[i-1][num+1][2] + dp[i-1][num+1][1]) % mod
            dp[i][num][0] = (dp[i-1][num+1][0] + dp[i-1][num+1][3]) % mod
        elif num == 9:
            dp[i][num][2] = (dp[i-1][num-1][2] + dp[i-1][num-1][0]) % mod
            dp[i][num][1] = (dp[i-1][num-1][1] + dp[i-1][num-1][3]) % mod
        else:
            dp[i][num][0] = (dp[i-1][num+1][0] + dp[i-1][num-1][0]) % mod
            dp[i][num][1] = (dp[i-1][num+1][1] + dp[i-1][num-1][1]) % mod
            dp[i][num][2] = (dp[i-1][num+1][2] + dp[i-1][num-1][2]) % mod
            dp[i][num][3] = (dp[i-1][num+1][3] + dp[i-1][num-1][3]) % mod

print(sum(dp[n][i][2] for i in range(10)) % mod)