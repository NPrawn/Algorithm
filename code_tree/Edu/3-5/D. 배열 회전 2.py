n, d = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

def rotate():
	dxdy = [[-1,-1],[-1,0],[-1,1],[0,1],[1,1],[1,0],[1,-1],[0,-1]]
	k = n//2
	pos = [[k,k] for _ in range(8)]
	for _ in range(k+1):
		tmp = grid[pos[0][0]][pos[0][1]]
		for i in range(7):
			grid[pos[i][0]][pos[i][1]] = grid[pos[i+1][0]][pos[i+1][1]]
		grid[pos[7][0]][pos[7][1]] = tmp
		for a, b in zip(pos, dxdy):
			a[0] += b[0]
			a[1] += b[1]
d = -d
t = d//45
if t<0: t+=8
for _ in range(t):
	rotate()

for e in grid:
	print(*e)