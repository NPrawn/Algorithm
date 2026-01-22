n = int(input())
arr = list(map(int, input().split()))
target = arr[-1]
arr = arr[:-1]
dp = [[0 for _ in range(21)] for _ in range(n-1)]

for idx in range(1, n):
    i = idx-1
    if idx==1:
        dp[0][arr[i]] = 1
        continue
    for j in range(21):
        if j-arr[i]>=0:
            dp[i][j] = dp[i-1][j-arr[i]]
        if j+arr[i] <= 20:
            dp[i][j] += dp[i-1][j+arr[i]]

print(dp[-1][target])