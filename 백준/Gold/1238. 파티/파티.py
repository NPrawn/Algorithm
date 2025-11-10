import heapq

n, m, x = map(int, input().split())
adj1 = [[] for _ in range(n+1)]
adj2 = [[] for _ in range(n+1)]
for _ in range(m):
	u,v,w = map(int, input().split())
	adj1[u].append([w,v])
	adj2[v].append([w,u])
inf = float('inf')
dist1 = [inf for _ in range(n + 1)]
dist2 = [inf for _ in range(n + 1)]
dist1[x] = 0
dist2[x] = 0

def f(adj, dist):
	q = []
	heapq.heappush(q, [0, x])
	while q:
		now_w, now_v = heapq.heappop(q)
		if dist[now_v] != now_w: continue
		for nxt_w, nxt_v in adj[now_v]:
			if dist[nxt_v] <= dist[now_v] + nxt_w: continue
			dist[nxt_v] = dist[now_v] + nxt_w
			heapq.heappush(q, [dist[nxt_v], nxt_v])

f(adj1, dist1)
f(adj2, dist2)

ans = 0
for i in range(1, n+1):
	if dist1[i]==inf or dist2[i]==inf: continue
	ans = max(ans, dist1[i]+dist2[i])
print(ans)