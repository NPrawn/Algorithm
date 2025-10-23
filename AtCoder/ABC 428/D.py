import math

T = int(input())
ans = []
for _ in range(T):
    c, d = map(int, input().split())
    res = 0
    k = 1
    while k<=c+d:
        l = max(1, k-c)
        r = min(d, k*10 - 1 - c)
        if l<=r:
            l = c*k*10 + c + l - 1
            r = c*k*10 + c + r
            res += math.isqrt(r)
            res -= math.isqrt(l)
        k*=10
    ans.append(res)

for e in ans:
    print(e)