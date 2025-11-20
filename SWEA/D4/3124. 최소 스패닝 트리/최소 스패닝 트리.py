T = int(input())

def find(x):
	while p[x] != x:
		p[x] = p[p[x]]
		x = p[x]
	return x

def union(a, b):
	a = find(a)
	b = find(b)
	
	if a>b:
		p[a] = b
	else:
		p[b] = a

for tc in range(1, T+1):
	V, E = map(int, input().split())
	edges = []
	p = [i for i in range(V+1)]
	for _ in range(E):
		u,v,w = map(int, input().split())
		edges.append([u,v,w])
	
	edges.sort(key = lambda x: x[2])
	
	ct = 0
	ans = 0
	for u,v,w in edges:
		if ct==V-1:
			break
		a = find(u)
		b = find(v)
		if a==b: continue
		union(a,b)
		ans += w
		ct+=1
	print(f'#{tc} {ans}')