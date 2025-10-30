n = int(input())
grid = [[-1 for _ in range(1005)] for _ in range(1005)]
for _ in range(n):
	x,y,a,b = map(int, input().split())
	for i in range(a):
		for j in range(b):
			grid[x+i][y+j] = _

ans = [0 for _ in range(n)]

for i in range(1005):
	for j in range(1005):
		if grid[i][j] == -1: continue
		ans[grid[i][j]] += 1

for e in ans:
	print(e)