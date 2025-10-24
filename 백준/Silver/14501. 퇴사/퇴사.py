n = int(input())
tasks = []
for i in range(n):
    a, b = map(int,input().split())
    tasks.append([i+1,a+i,b])

dp = [0 for _ in range(n+1)]
for i in range(1, n+1):
    for st, en, val in tasks:
        if en!=i: continue
        dp[i] = max(dp[i], max(dp[:st])+val)

print(max(dp))