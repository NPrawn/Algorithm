n, k = map(int, input().split())
grid = [[0 for _ in range(n+1)]]
for _ in range(n):
	arr = [0] + list(map(int, input().split()))
	grid.append(arr)

S = [[0 for _ in range(n+1)] for _ in range(n+1)]
for i in range(1, n+1):
	r_sum = 0
	for j in range(1, n+1):
		r_sum += grid[i][j]
		S[i][j] = S[i-1][j] + r_sum
		
ans = -float('inf')
for i in range(1, n+2-k):
	for j in range(1, n+2-k):
		x1,y1 = i, j
		x2,y2 = i+k-1, j+k-1
		ans = max(ans, S[x2][y2] - S[x1-1][y2] - S[x2][y1-1] + S[x1-1][y1-1])

print(ans)