n = int(input())
MOD = 15746
dp = [0 for _ in range(n+1)]
dp[1] = 1
if n > 1:
    dp[2] = 2

for i in range(3, n+1):
    dp[i] = (dp[i-2]+dp[i-1]) % MOD

print(dp[n])