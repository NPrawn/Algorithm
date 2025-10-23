T = int(input())
res = []
for _ in range(T):
    n, k = map(int, input().split())
    casinos = []
    for i in range(n):
        casinos.append(tuple(map(int, input().split())))
    vis = set()
    casinos.sort()
    while True:
        tmp = k
        for casino in casinos:
            l, r, real = casino
            if casino in vis: continue
            if l <= k <= r and real > k:
                k = real
                vis.add(casino)
        if tmp == k: break
    res.append(k)

for e in res:
    print(e)