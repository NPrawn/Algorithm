import heapq

n, m, x = map(int, input().split())
adj1 = [[] for _ in range(n+1)]
adj2 = [[] for _ in range(n+1)]
inf = float('inf')
dist1 = [inf for _ in range(n+1)]
dist2 = [inf for _ in range(n+1)]

for _ in range(m):
    u,v,w = map(int, input().split())
    adj1[u].append((w,v))
    adj2[v].append((w,u))

def dijk(adj, dist):
    q = []
    heapq.heappush(q, (0, x))
    dist[x] = 0

    while q:
        w, now = heapq.heappop(q)
        if w != dist[now]: continue

        for nw, nxt in adj[now]:
            if dist[nxt] <= dist[now] + nw: continue
            dist[nxt] = dist[now] + nw
            heapq.heappush(q, (dist[nxt], nxt))

dijk(adj1, dist1)
dijk(adj2, dist2)

ans = 0
for a,b in zip(dist1, dist2):
    if a==inf or b==inf: continue
    ans = max(ans, a+b)

print(ans)