n = int(input())
tasks = [[] for _ in range(n+1)]

for i in range(n):
    a, b = map(int,input().split())
    if i+a > n: continue
    tasks[i+a].append([i+1, b])
dp = [0 for _ in range(n+1)]
for i in range(1, n+1):
    for st, val in tasks[i]:
        dp[i] = max(dp[i-1], dp[st-1]+val, dp[i])
    if dp[i]==0: dp[i] = dp[i-1]

print(max(dp))