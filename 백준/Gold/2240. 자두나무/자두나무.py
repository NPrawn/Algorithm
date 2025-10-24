N, K = map(int,input().split())
lst = [0]
for _ in range(N):
    lst.append(int(input()))

dp = [[0 for _ in range(K+1)] for _ in range(N+1)]
for i in range(1,N+1):
    dp[i][0] = dp[i-1][0]
    if lst[i]==1: dp[i][0] += 1

for i in range(1, N+1):
    for j in range(1, K+1):
        dp[i][j] = max(dp[i-1][j-1], dp[i-1][j])
        if j%2==0 and lst[i]==1: dp[i][j]+=1
        if j%2==1 and lst[i]==2: dp[i][j]+=1


print(max(dp[-1]))
