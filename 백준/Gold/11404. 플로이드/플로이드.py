n = int(input())
m = int(input())
inf = float('inf')
dist = [[inf for _ in range(n+1)] for _ in range(n+1)]

for _ in range(m):
	a, b, c = map(int, input().split())
	dist[a][b] = min(dist[a][b], c)
for i in range(n+1):
	dist[i][i] = 0

for k in range(1, n+1):
	for i in range(1, n+1):
		for j in range(1, n+1):
			dist[i][j] = min(dist[i][j], dist[i][k]+dist[k][j])

for i in range(1, n+1):
	for j in range(1, n+1):
		dist[i][j] = 0 if dist[i][j]==inf else dist[i][j]

for e in dist[1:]:
	print(*e[1:])