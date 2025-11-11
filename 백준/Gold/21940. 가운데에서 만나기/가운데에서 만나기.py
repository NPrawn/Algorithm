n, m = map(int ,input().split())
inf = float('inf')
d = [[inf for _ in range(n+1)] for _ in range(n+1)]
for _ in range(m):
	u,v,c = map(int, input().split())
	d[u][v] = min(d[u][v], c)
k = int(input())
arr = list(map(int, input().split()))

for i in range(n+1):
	d[i][i] = 0

for k in range(1, n+1):
	for i in range(1, n+1):
		for j in range(1, n+1):
			d[i][j] = min(d[i][j], d[i][k] + d[k][j])

ans = []
mn = inf
for i in range(1, n+1):
	ct = 0
	for a in arr:
		ct = max(ct, d[a][i] + d[i][a])
	ans.append(ct)
	mn = min(ct, mn)

for i in range(len(ans)):
	if ans[i]==mn:
		print(i+1, end=' ')