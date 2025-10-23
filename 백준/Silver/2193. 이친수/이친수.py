n = int(input())

dp = [[0,1],[1,0]]
for i in range(2,n):
    a = dp[-1][0] + dp[-1][1]
    b = dp[-1][0]
    dp.append([a,b])


print(dp[n-1][0]+dp[n-1][1])