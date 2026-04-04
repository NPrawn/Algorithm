n, m = map(int, input().split())
adj = [[0 for _ in range(n+1)] for _ in range(n+1)]
inf = float('inf')
dist = [inf for _ in range(n+1)]
for _ in range(m):
    u, v, w = map(int, input().split())
    adj[u][v] = w
    adj[v][u] = w

a, b = map(int, input().split())
dist[b] = 0
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

print(dist[a])

print(a, end=' ')
while a != b:
    for i in range(1, n+1):
        if adj[i][a] == 0: continue

        if dist[i] + adj[i][a] == dist[a]:
            a=i
            break
    
    print(a, end=' ')