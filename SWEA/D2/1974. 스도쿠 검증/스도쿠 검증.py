T = int(input())
for tc in range(1, T+1):
	grid = [list(map(int, input().split())) for _ in range(9)]
	ok = True
	for e in grid:
		s = set(e)
		if len(s)!=9: ok = False
	for e in zip(*grid):
		s = set(e)
		if len(s) != 9: ok = False
	
	for i in range(3):
		for j in range(3):
			ct = set()
			for x in range(i*3, i*3+3):
				for y in range(j*3, j*3+3):
					ct.add(grid[x][y])
			if len(ct) != 9: ok = False
	
	print(f'#{tc} 1' if ok else f'#{tc} 0')