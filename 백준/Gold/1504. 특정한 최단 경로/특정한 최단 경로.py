import heapq

n, m = map(int, input().split())
adj = [[] for _ in range(n+1)]
for _ in range(m):
	u,v,w = map(int, input().split())
	adj[u].append([w,v])
	adj[v].append([w,u])
v1, v2 = map(int, input().split())
inf = float('inf')
dv1 = [inf for _ in range(n+1)]
dv2 = [inf for _ in range(n+1)]
dn = [inf for _ in range(n+1)]

def f(dist, st):
	q = []
	heapq.heappush(q, [0, st])
	dist[st] = 0
	while q:
		w, v = heapq.heappop(q)
		if dist[v] != w: continue
		for nw, nv in adj[v]:
			if dist[nv] <= dist[v]+nw: continue
			dist[nv] = dist[v]+nw
			heapq.heappush(q, [dist[nv], nv])

f(dv1, 1)
f(dv2, v1)
f(dn, v2)
ans = dv1[v1]+dv2[v2]+dn[n]
dv1 = [inf for _ in range(n+1)]
dv2 = [inf for _ in range(n+1)]
dn = [inf for _ in range(n+1)]
f(dv2, 1)
f(dv1, v2)
f(dn, v1)

ans = min(ans, dv1[v1]+dv2[v2]+dn[n])

print(-1 if ans==inf else ans)