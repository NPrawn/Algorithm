n = int(input())
neg = False
if n < 0: neg = True; n = abs(n)
MOD = 1000000000
dp = [0,1]
for i in range(2, n+1):
    dp.append((dp[-2]+dp[-1])%MOD)

if neg:
    if n%2==0:
        print(-1)
        print(dp[n])
    else:
        print(1)
        print(dp[n])
else:
    if dp[n]==0:
        print(0)
        print(dp[n])
    else:
        print(1)
        print(dp[n])