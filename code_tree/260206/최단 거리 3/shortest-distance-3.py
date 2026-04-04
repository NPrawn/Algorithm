import heapq
inf = float('inf')

n, m = map(int, input().split())
adj = [[] for _ in range(n+1)]
for _ in range(m):
    u,v,w = map(int, input().split())
    adj[u].append((w,v))
    adj[v].append((w,u))

dist = [inf for _ in range(n+1)]
a, b = map(int, input().split())

dist[a] = 0
q = []
heapq.heappush(q, (0, a))

while q:
    w, now = heapq.heappop(q)
    if w != dist[now]: continue

    for nw, nxt in adj[now]:
        if dist[nxt] <= dist[now] + nw: continue
        dist[nxt] = dist[now] + nw
        heapq.heappush(q, (dist[nxt], nxt))

print(dist[b])