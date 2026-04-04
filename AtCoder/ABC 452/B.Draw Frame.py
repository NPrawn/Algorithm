h, w = map(int, input().split())

grid = [['.' for _ in range(w)] for _ in range(h)]
for x in range(h):
	for y in range(w):
		if x == 0 or x == h-1 or y == 0 or y == w-1:
			grid[x][y] = '#'

for row in grid:
	print(''.join(row))
	