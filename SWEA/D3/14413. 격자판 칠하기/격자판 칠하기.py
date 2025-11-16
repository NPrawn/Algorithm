T = int(input())
ans = []
for _ in range(T):
	n, m = map(int, input().split())
	grid = [list(input()) for _ in range(n)]
	ok = True
	for i in range(n):
		for j in range(m):
			if grid[i][j] == '?': continue
			if grid[i][j] == '#': c = '.'
			else: c = '#'
			for dx, dy in [[1,0],[0,1],[-1,0],[0,-1]]:
				nx,ny = i+dx, j+dy
				if not (0<=nx<n and 0<=ny<m): continue
				if grid[nx][ny]==c: continue
				if grid[nx][ny]!='?': ok = False; break
				grid[nx][ny] = c
			
			if not ok: break
		if not ok: break
	
	ans.append('possible' if ok else 'impossible')

for i, e  in enumerate(ans):
	print(f'#{i+1} {e}')