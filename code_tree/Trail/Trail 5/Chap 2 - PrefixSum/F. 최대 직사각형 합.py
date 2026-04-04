n = int(input())
grid = [list(map(int, input().split())) for _ in range(n)]
inf = float('inf')
ans = -inf

for top in range(n):
	col = [0] * n
	for bottom in range(top, n):
		row = grid[bottom]
		for c in range(n):
			col[c] += row[c]
		
		cur = 0
		best = -inf
		for x in col:
			cur = max(x, cur+x)
			best = max(best, cur)
		
		ans = max(ans, best)

print(ans)