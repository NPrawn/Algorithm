T = int(input())
for tc in range(1, T+1):
	n, m = map(int, input().split())
	grid = [list(map(int, input().split())) for _ in range(n)]
	ans = -1
	for i in range(n-m+1):
		for j in range(n-m+1):
			ct = 0
			for x in range(i, i+m):
				for y in range(j, j+m):
					ct += grid[x][y]
			ans = max(ans,ct)
	if n==m:
		ans = 0
		for e in grid:
			ans += sum(e)
	print(f'#{tc} {ans}')