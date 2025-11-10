import heapq

n = int(input())
m = int(input())
adj= [[] for _ in range(n+1)]
for _ in range(m):
	st,en,d = map(int, input().split())
	adj[st].append([d,en])

q=[]
inf = float('inf')
d = [inf for _ in range(n+1)]
st, en = map(int, input().split())
d[st] = 0
heapq.heappush(q, [0, st])
while q:
	w, v = heapq.heappop(q)
	if d[v] != w: continue
	for nw, nv in adj[v]:
		if d[nv]<=d[v]+nw: continue
		d[nv] = d[v]+nw
		heapq.heappush(q, [d[nv], nv])

print(d[en])