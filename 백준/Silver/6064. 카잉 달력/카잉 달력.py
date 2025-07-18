t = int(input())

for _ in range(t):
    m, n, x, y = map(int, input().split())
    ans = -1
    k = x
    while k <= m*n:
        if (k-1) % n + 1 == y:
            ans = k
            break
        k += m
    print(ans)