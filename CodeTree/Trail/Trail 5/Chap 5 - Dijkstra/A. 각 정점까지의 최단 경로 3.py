import heapq

n, m = map(int, input().split())
adj = [[] for _ in range(n+1)]
for _ in range(m):
	u,v,w = map(int ,input().split())
	adj[u].append([w,v])
inf = float('inf')
d = [inf for _ in range(n+1)]
q = []
heapq.heappush(q, [0, 1])
d[1] = 0
while q:
	w, v = heapq.heappop(q)
	if d[v]!=w: continue
	for nw, nv in adj[v]:
		if d[nv] <= d[v] + nw: continue
		d[nv] = d[v]+nw
		heapq.heappush(q, [d[nv], nv])

for i in range(2, n+1):
	print(d[i] if d[i]!=inf else -1)