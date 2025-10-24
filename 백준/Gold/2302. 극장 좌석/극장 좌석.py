N = int(input())
M = int(input())
fix = []
dp = [0,1,2]
for i in range(2,N+5):
    dp.append(dp[-2]+dp[-1])
for _ in range(M):
    fix.append(int(input()))
fix.append(N+1)
now = 0
ans = 1
for f in fix:
    k = f-now-1
    now = f
    if k<=0: continue
    ans *= dp[k]

print(ans)