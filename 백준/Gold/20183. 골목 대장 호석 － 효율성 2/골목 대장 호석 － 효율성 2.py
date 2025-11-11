import heapq

n,m,a,b,c = map(int, input().split())
adj = [[] for _ in range(n+1)]
st, en = 1, 0
inf = float('inf')

for _ in range(m):
	u,v,w = map(int, input().split())
	adj[u].append([w,v])
	adj[v].append([w,u])
	en = max(en, w)

def can(mid):
	q = []
	heapq.heappush(q,[0, a])
	d = [inf for _ in range(n+1)]
	d[a] = 0
	while q:
		w, v = heapq.heappop(q)
		if d[v] != w: continue
		for nw, nv in adj[v]:
			if nw > mid: continue
			if d[nv] <= d[v]+nw: continue
			d[nv] = d[v]+nw
			heapq.heappush(q, [d[nv], nv])
	
	if d[b]>c: return False
	return True
	
ans = inf
en +=1
while st<en:
	mid = (st+en)//2
	if can(mid):
		en = mid
		ans = mid
	else:
		st = mid+1

print(ans if ans!=inf else -1)