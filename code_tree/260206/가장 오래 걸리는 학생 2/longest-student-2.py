import heapq
inf = float('inf')

n, m = map(int, input().split())
adj = [[] for _ in range(n+1)]
d = [inf for _ in range(n+1)]

for _ in range(m):
    u, v, w = map(int, input().split())
    adj[v].append((w, u))

q = []
d[n] = 0
heapq.heappush(q, (0, n))

while q:
    w, now = heapq.heappop(q)
    if w != d[now]: continue

    for nw, nxt in adj[now]:
        if d[nxt] <= d[now] + nw: continue
        d[nxt] = d[now] + nw
        heapq.heappush(q, (d[nxt], nxt))
    
print(max(d[i] if d[i] != inf else 0 for i in range(n+1)))