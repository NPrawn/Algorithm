import heapq
inf = float('inf')

n, m = map(int, input().split())
r1, r2 = map(int, input().split())

adj = [[] for _ in range(n+1)]
dist1 = [inf for _ in range(n+1)]
dist2 = [inf for _ in range(n+1)]

for _ in range(m):
    u, v, w = map(int, input().split())
    adj[u].append((w,v))
    adj[v].append((w,u))

q = [(0, r1)]
dist1[r1] = 0

while q:
    w, now = heapq.heappop(q)
    if w != dist1[now]: continue

    for nw, nxt in adj[now]:
        if dist1[nxt] <= dist1[now] + nw: continue
        dist1[nxt] = dist1[now] + nw
        heapq.heappush(q, (dist1[nxt], nxt))

q = [(0, r2)]
dist2[r2] = 0

while q:
    w, now = heapq.heappop(q)
    if w != dist2[now]: continue

    for nw, nxt in adj[now]:
        if dist2[nxt] <= dist2[now] + nw: continue
        dist2[nxt] = dist2[now] + nw
        heapq.heappush(q, (dist2[nxt], nxt))


ans = inf
dist = dist1[r2]
for i in range(1, n+1):
    if i==r1 or i==r2: continue
    ans = min(ans, dist + dist1[i] + dist2[i])

print(ans)