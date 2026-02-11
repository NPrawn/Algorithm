from collections import deque
import heapq

n, m = map(int, input().split())
adj = [[0 for _ in range(n+1)] for _ in range(n+1)]
inf = float('inf')
dist = [inf for _ in range(n+1)]
for _ in range(m):
    u, v, w = map(int, input().split())
    adj[u][v] = w
    adj[v][u] = w

dist[1] = 0
vis = [False for _ in range(n+1)]

for i in range(1, n+1):
    min_idx = -1
    for j in range(1, n+1):
        if vis[j]: continue
        if min_idx != -1 and dist[min_idx] <= dist[j]: continue
        min_idx = j
    
    vis[min_idx] = True

    for j in range(1, n+1):
        if adj[min_idx][j] == 0: continue
        if dist[j] <= dist[min_idx] + adj[min_idx][j]: continue
        dist[j] = dist[min_idx] + adj[min_idx][j]

a, b = n, 1
p = deque()
p.appendleft(a)
while a != b:
    for i in range(1, n+1):
        if adj[i][a] == 0: continue

        if dist[i] + adj[i][a] == dist[a]:
            a=i
            break
    
    p.appendleft(a)

now = p.popleft()
while p:
    nxt = p.popleft()
    adj[now][nxt] = 0
    adj[nxt][now] = 0
    now = nxt

q = []
dist = [inf for _ in range(n+1)]
dist[1] = 0
heapq.heappush(q, (0, 1))

while q:
    w, now = heapq.heappop(q)
    if dist[now] != w: continue

    for nxt, nw in enumerate(adj[now]):
        if nw == 0: continue
        if dist[nxt] <= dist[now] + nw: continue
        dist[nxt] = dist[now] + nw
        heapq.heappush(q, (dist[nxt], nxt))

print(dist[n])