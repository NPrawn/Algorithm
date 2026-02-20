import heapq

n, m = map(int, input().split())
adj = [[] for _ in range(n+1)]
for _ in range(n-1):
    a, b, c = map(int, input().split())
    adj[a].append((c,b))
    adj[b].append((c,a))

for _ in range(m):
    a, b = map(int, input().split())
    inf = float('inf')
    d = [inf for _ in range(n+1)]
    d[a] = 0
    q = []
    heapq.heappush(q, (0, a))
    while q:
        w, now = heapq.heappop(q)
        for nw, nxt in adj[now]:
            if d[nxt] <= d[now] + nw: continue
            d[nxt] = d[now] + nw
            heapq.heappush(q, (d[nxt], nxt))
    
    print(d[b])