import heapq

n, m = map(int, input().split())
k = int(input())
adj = [[] for _ in range(n+1)]
for _ in range(m):
	u,v,w = map(int, input().split())
	adj[u].append([w,v])
	adj[v].append([w,u])

inf = float('inf')
d = [inf for _ in range(n+1)]
q = []
heapq.heappush(q, [0, k])
d[k] = 0
while q:
	w, v = heapq.heappop(q)
	if d[v]!=w: continue
	for nw, nv in adj[v]:
		if d[nv] <= nw + d[v]: continue
		d[nv] = nw+ d[v]
		heapq.heappush(q, [d[nv],nv])

for e in d[1:]:
	print(e if e!=inf else -1)