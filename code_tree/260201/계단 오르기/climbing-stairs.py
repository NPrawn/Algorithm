n = int(input())
mod = 10007

dp = [0, 0, 1, 1]

for i in range(4, n+1):
    dp.append((dp[-2]+dp[-3]) % mod)

print(dp[n] % mod)