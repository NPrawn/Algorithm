import heapq

inf = float('inf')
n, m, x = map(int, input().split())
adj = [[] for _ in range(n+1)]
cs = set()
ans = inf
for _ in range(m):
    i, j, l, c = map(int, input().split())
    adj[i].append((j,l,c))
    adj[j].append((i,l,c))
    cs.add(c)

for a in sorted(cs, reverse=True):
    dist = [inf for _ in range(n+1)]
    dist[1] = 0
    pq = [(0,1)]
    b = inf
    while pq:
        d, u = heapq.heappop(pq)
        if d != dist[u]:
            if c < a: continue
        if u == n:
            b=d
            break
        for v, l, c in adj[u]:
            if c < a: continue
            if dist[v] <= dist[u] + l: continue
            dist[v] = dist[u] + l
            heapq.heappush(pq, (dist[v], v))
    
    if b >= inf: continue
    ans = min(ans, b+x/a)

print(int(ans))