inf = float('inf')

m = 1005
a, b, n = map(int, input().split())
g = [[(inf, 0) for _ in range(m+1)] for _ in range(m+1)]
dist = [(inf, 0) for _ in range(m+1)]
vis = [False for _ in range(m+1)]

for i in range(1, m+1):
    g[i][i] = (0,0)

for _ in range(n):
    cost, stop_num = tuple(map(int, input().split()))
    stops = list(map(int, input().split()))

    for i in range(stop_num):
        for j in range(i+1, stop_num):
            g[stops[i]][stops[j]] = min(g[stops[i]][stops[j]], (cost, j - i))
    

dist[a] = (0, 0)

for _ in range(m):
    idx = -1
    for i in range(1, m+1):
        if vis[i]: continue
        if idx == -1 or dist[idx] > dist[i]:
            idx = i
    vis[idx] = True
    ans = []
    min_cost, min_time = dist[idx]

    for i in range(1, m+1):
        cost, time = g[idx][i]
        dist[i] = min(dist[i], (min_cost + cost, min_time + time))

if dist[b] == (inf, 0):
    dist[b] = (-1, -1)

print(*dist[b])