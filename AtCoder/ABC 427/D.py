T = int(input())
ans = []

for _ in range(T):
    N, M, K = map(int, input().split())
    S = [None] + list(input())
    g = [[] for _ in range(N+1)]
    for _ in range(M):
        u, v = map(int, input().split())
        g[u].append(v)
    K += K
    dp = [[0 for _ in range(N+1)] for _ in range(K+1)]
    for n in range(1, N+1):
        if S[n]=='A': dp[K][n]=1
    for k in range(K-1, -1, -1):
        if k%2==1:
            # Bob's Turn
            for n in range(1, N+1):
                canWin = False
                for v in g[n]:
                    if dp[k+1][v]==0: canWin=True
                if canWin: dp[k][n]=0
                else: dp[k][n]=1
        else:
            #Alice's Turn
            for n in range(1, N+1):
                canWin = False
                for v in g[n]:
                    if dp[k+1][v]==1: canWin=True
                if canWin: dp[k][n]=1
                else: dp[k][n]=0
    
    ans.append(dp[0][1])

for e in ans:
    print('Alice' if e==1 else 'Bob')