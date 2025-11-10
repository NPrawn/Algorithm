n, m, r = map(int, input().split())
arr = [0] + list(map(int, input().split()))
inf = float('inf')
dist = [[inf for _ in range(n+1)] for _ in range(n+1)]

for i in range(n+1):
	dist[i][i] = 0

for _ in range(r):
	a,b,c = map(int, input().split())
	dist[a][b] = min(dist[a][b], c)
	dist[b][a] = min(dist[b][a], c)

for k in range(1, n+1):
	for i in range(1, n+1):
		for j in range(1, n+1):
			if dist[i][j] > dist[i][k]+dist[k][j]:
				dist[i][j] = dist[i][k]+dist[k][j]

ans = -inf
for i in range(1, n+1):
	ct = 0
	for j in range(1, n+1):
		if dist[i][j]>m: continue
		ct += arr[j]
	ans = max(ans,ct)

print(ans)