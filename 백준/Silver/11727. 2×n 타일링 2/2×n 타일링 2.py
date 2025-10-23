n = int(input())
dp = [1, 3]
for i in range(3,n+1):
    dp.append((dp[-2]+dp[-2]+dp[-1])%10007)

print(dp[n-1])