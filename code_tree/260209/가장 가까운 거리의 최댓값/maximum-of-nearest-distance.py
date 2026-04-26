import heapq

n, m = map(int, input().split())
a, b, c = map(int, input().split())

adj = [[] for _ in range(n+1)]
inf = float('inf')
dist = [inf for _ in range(n+1)]

for _ in range(m):
    u, v, w = map(int, input().split())
    adj[u].append((w,v))
    adj[v].append((w,u))

q = []
dist[a] = dist[b] = dist[c] = 0
heapq.heappush(q, (0, a))
heapq.heappush(q, (0, b))
heapq.heappush(q, (0, c))

while q:
    w, now = heapq.heappop(q)
    if w != dist[now]: continue
    for nw, nxt, in adj[now]:
        if dist[nxt] <= dist[now] + nw: continue
        dist[nxt] = dist[now] + nw
        heapq.heappush(q, (dist[nxt], nxt))

ans = 0
for e in dist:
    if e == inf: continue
    ans = max(ans, e)

print(ans)