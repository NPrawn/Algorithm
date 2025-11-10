import heapq

n = int(input())
m = int(input())
adj = [[] for _ in range(n+1)]
for _ in range(m):
	u,v,w = map(int, input().split())
	adj[u].append([w,v])
inf = float('inf')
dist = [inf for _ in range(n+1)]
st, en = map(int, input().split())
dist[st] = 0
pre = [0 for _ in range(n+1)]
q = []
heapq.heappush(q, [0, st])
while q:
	now_w, now_v = heapq.heappop(q)
	if dist[now_v] != now_w: continue
	for nxt_w, nxt_v in adj[now_v]:
		if dist[nxt_v] <= dist[now_v]+nxt_w: continue
		dist[nxt_v] = dist[now_v]+nxt_w
		heapq.heappush(q, [dist[nxt_v], nxt_v])
		pre[nxt_v] = now_v

print(dist[en])
ans = []
while en != st:
	ans.append(en)
	en = pre[en]
ans.append(st)
print(len(ans))
print(*reversed(ans))