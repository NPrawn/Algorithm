MOD = 998244353

n = int(input())
t = input()
dp = [0 for _ in range(1 << n)]
dp[(1<<n)-1] = 1

for bit in range((1<<n)-1, -1, -1):
    dp[bit] %= MOD
    pre = '?'
    for i in range(n):
        if (bit >> i)&1:
            if pre != t[i]:
                dp[bit^(1<<i)] += dp[bit]
            pre = t[i]
print(dp[0])