T, MOD = map(int, input().split())
K = 5010
binom = [[0 for _ in range(K)] for _ in range(K)]
binom[0][0] = 1

for n in range(1, K):
    binom[n][0] = 1
    for k in range(1, n+1):
        binom[n][k] = (binom[n-1][k-1] + binom[n-1][k]) % MOD

ans = []
for _ in range(T):
    N = int(input())
    arr = list(map(int, input().split()))
    res = 1
    s = 0
    for i in arr:
        s+=i
        res *= binom[s][i]
        res %= MOD
    ans.append(res%MOD)

for a in ans:
    print(a)