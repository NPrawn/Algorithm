import heapq

n, m, k = map(int, input().split())
adj = [[] for _ in range(n+1)]
for _ in range(m):
	u, v, w = map(int, input().split())
	adj[v].append([w,u])

inf = float('inf')
arr = list(map(int, input().split()))
ans = [inf for _ in range(n+1)]
d = [inf for _ in range(n+1)]
q = []
for st in arr:
	heapq.heappush(q, [0, st])
	d[st] = 0

while q:
	w, v = heapq.heappop(q)
	if d[v] != w: continue
	for nw, nv in adj[v]:
		if d[nv] <= d[v]+nw: continue
		d[nv] = d[v]+nw
		heapq.heappush(q, [d[nv], nv])
for i in range(n+1):
	ans[i] = min(ans[i], d[i])

for i in range(n+1):
	ans[i] = 0 if ans[i]==inf else ans[i]

mx = max(ans)
for i, a in enumerate(ans):
	if a==mx: print(i); break
print(mx)