T = int(input())
ans = []
inf = float('inf')
for _ in range(T):
	n = int(input())
	grid = [list(input()) for _ in range(n)]
	minx = inf
	miny = inf
	maxx = -inf
	maxy = -inf
	for i in range(n):
		for j in range(n):
			if grid[i][j] == '.': continue
			minx = min(minx, i)
			miny = min(miny, j)
			maxx = max(maxx, i)
			maxy = max(maxy, j)
	
	ok = True
	for x in range(minx, maxx+1):
		for y in range(miny, maxy+1):
			if grid[x][y] == '.': ok = False
	if maxx-minx != maxy-miny: ok = False
	ans.append('yes' if ok else 'no')

for i, e in enumerate(ans):
	print(f'#{i+1} {e}')