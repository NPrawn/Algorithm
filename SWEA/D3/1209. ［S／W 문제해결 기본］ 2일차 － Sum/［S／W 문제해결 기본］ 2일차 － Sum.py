for _ in range(10):
	tc = int(input())
	grid = [list(map(int, input().split())) for _ in range(100)]
	ans = 0
	for e in grid:
		ans = max(ans, sum(e))
	for e in zip(*grid):
		ans = max(ans, sum(e))
	ct1 = 0
	ct2 = 0
	for i in range(100):
		ct1 += grid[i][i]
		ct2 += grid[i][99-i]
	ans = max(ans, ct1, ct2)
	print(f'#{tc} {ans}')