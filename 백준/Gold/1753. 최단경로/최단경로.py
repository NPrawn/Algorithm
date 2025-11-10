import heapq

V, E = map(int ,input().split())
st = int(input())
inf = float('inf')
dist = [inf for _ in range(V+1)]
dist[st] = 0
hq = []
heapq.heappush(hq, [0,st])
adj = [[] for _ in range(V+1)]
for _ in range(E):
	u,v,w = map(int, input().split())
	adj[u].append([w,v])

while hq:
	now_w, now_v = heapq.heappop(hq)
	if dist[now_v] != now_w: continue
	for nxt_w, nxt_v in adj[now_v]:
		if dist[nxt_v] <= dist[now_v]+nxt_w: continue
		dist[nxt_v] = dist[now_v]+nxt_w
		heapq.heappush(hq, [dist[nxt_v], nxt_v])

for e in dist[1:]:
	print('INF' if e==inf else e)