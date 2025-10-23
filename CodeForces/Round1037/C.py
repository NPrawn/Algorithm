T = int(input())

res = []
for _ in range(T):
    n, k = map(int, input().split())
    h = list(map(int, input().split()))
    now = h[k-1]
    h.sort()
    t = 0
    for i in h:
        if now == h[n-1]:
            res.append("YES")
            break
        if now >= i: continue
        if (now - t) < (i - now):
            res.append("NO")
            break
        t += i-now
        now = i
        if i == h[n-1]:
            res.append("YES")
            break

for e in res:
    print(e)