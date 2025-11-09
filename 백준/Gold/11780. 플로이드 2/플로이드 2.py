n = int(input())
m = int(input())
inf = float('inf')
dist = [[inf for _ in range(n+1)] for _ in range(n+1)]
roots =[[[] for _ in range(n+1)] for _ in range(n+1)]

for i in range(n+1):
	dist[i][i] = 0
	
for _ in range(m):
	a, b, c = map(int, input().split())
	if dist[a][b] > c:
		dist[a][b] = c
		roots[a][b] = [a,b]
		
for k in range(1, n+1):
	for i in range(1, n+1):
		for j in range(1, n+1):
			if dist[i][j] > dist[i][k]+dist[k][j]:
				dist[i][j] = dist[i][k]+dist[k][j]
				roots[i][j] = roots[i][k][:-1] + [k] + roots[k][j][1:]

for i in range(1, n+1):
	for j in range(1, n+1):
		dist[i][j] = 0 if dist[i][j]==inf else dist[i][j]
		
for e in dist[1:]:
	print(*e[1:])

for i in range(1, n+1):
	for j in range(1, n+1):
		k = len(roots[i][j])
		if k==0:
			print(0)
		else:
			print(k, *roots[i][j])
			
		