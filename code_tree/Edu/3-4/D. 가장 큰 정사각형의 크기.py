n, m = map(int, input().split())
grid = [list(map(int,input().split())) for _ in range(n)]
d = [[0 for _ in range(m)] for _ in range(n)]

for i in range(n):
	d[i][0] = grid[i][0]
for i in range(m):
	d[0][i] = grid[0][i]

for i in range(1, n):
	for j in range(1, m):
		if grid[i][j]==0: continue
		d[i][j] = min(d[i-1][j], d[i][j-1], d[i-1][j-1])+1

ans = 0
for row in d:
	ans = max(ans, max(row))

print(ans*ans)