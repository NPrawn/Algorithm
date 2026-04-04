from collections import deque

n, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]
dxdy = [[1,0],[0,1],[-1,0],[0,-1]]

ans = 0
def check():
	q = deque()
	d = [[0 for _ in range(m)] for _ in range(n)]
	idx = 1
	for i in range(1, n-1):
		for j in range(1, m-1):
			if d[i][j] != 0: continue
			if grid[i][j] == 0: continue
			if idx>=2: return True
			q.append([i,j])
			d[i][j] = idx
			while q:
				x, y = q.popleft()
				for dx,dy in dxdy:
					nx,ny = x+dx, y+dy
					if grid[nx][ny] == 0: continue
					if d[nx][ny] != 0: continue
					q.append([nx,ny])
					d[nx][ny] = idx
			idx+=1
	return False

while True:
	if check(): break;
	ans+=1
	new_grid = [row[:] for row in grid]
	ok = True
	for x in range(1, n-1):
		for y in range(1, m-1):
			if grid[x][y] == 0: continue
			ok = False
			ct = 0
			for dx,dy in dxdy:
				nx,ny = x+dx,y+dy
				if grid[nx][ny]==0: ct+=1
			new_grid[x][y] = max(0, grid[x][y]-ct)
	grid = new_grid
	if ok: ans=0; break

print(ans)