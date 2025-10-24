T = int(input())
MOD = 1000000009
dp = [0,1,2,4]
for i in range(4, 1000001):
    dp.append((dp[i-3] + dp[i-2] + dp[i-1])%MOD)

for _ in range(T):
    n = int(input())
    print(dp[n])