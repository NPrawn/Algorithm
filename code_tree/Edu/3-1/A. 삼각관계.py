n, m = map(int, input().split())
adj = [set() for _ in range(m+1)]
edges = []
for _ in range(m):
	a, b = map(int, input().split())
	adj[a].add(b)
	adj[b].add(a)
	edges.append([a,b])

ans = 0
for a, b in edges:
	lst = adj[a] & adj[b]
	ct = 0
	for k in lst:
		if k==a or k==b: ct-=1
		else: ct+=1
	ans += ct
ans /= 3
print('YES' if ans>=2 else 'NO')