import heapq

n, m = map(int, input().split())
adj = [[0 for _ in range(n+1)] for _ in range(n+1)]
for _ in range(m):
    a,b,c = map(int, input().split())
    adj[a][b] = c
    adj[b][a] = c
inf = float('inf')
dist = [inf for _ in range(n+1)]
path = [0 for _ in range(n+1)]
def dijk():
    for i in range(1, n+1):
        dist[i] = inf
        path[i] = 0
    dist[1] = 0
    q = []

    heapq.heappush(q, (0, 1))
    while q:
        w, now = heapq.heappop(q)
        if w != dist[now]: continue
        
        for nxt, nw in enumerate(adj[now]):
            if nw == 0: continue
            if dist[nxt] <= dist[now] + nw: continue
            dist[nxt] = dist[now] + nw
            heapq.heappush(q, (dist[nxt], nxt))
            path[nxt] = now
dijk()
x = n
A = [x]
while x!=1:
    x = path[x]
    A.append(x)

A.reverse()
ans = 0
d = dist[n]
for a,b in zip(A[:-1], A[1:]):
    tmp = adj[a][b]
    adj[a][b] = 0
    adj[b][a] = 0

    dijk()
    adj[a][b] = tmp
    adj[b][a] = tmp
    if dist[n] == d: continue
    ans += 1

print(ans)