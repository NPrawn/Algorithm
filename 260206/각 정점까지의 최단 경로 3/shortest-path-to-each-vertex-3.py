import heapq

push = heapq.heappush
pop = heapq.heappop
inf = float('inf')

n, m = map(int, input().split())
adj = [[] for _ in range(n + 1)]
dist = [inf for _ in range(n + 1)]

for _ in range(m):
    u, v, w = map(int, input().split())
    adj[u].append((w, v))

q = []
push(q, (0, 1))
dist[1] = 0

while q:
    w, now = pop(q)
    if w != dist[now]: continue

    for nw, nxt in adj[now]:
        if dist[nxt] <= dist[now] + nw: continue
        dist[nxt] = dist[now] + nw
        push(q, (dist[nxt], nxt))

for i in range(2, n+1):
    print(dist[i] if dist[i] != inf else -1)