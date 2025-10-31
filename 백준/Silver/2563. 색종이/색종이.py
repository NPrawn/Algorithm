n = int(input())
grid = [[0 for _ in range(105)] for _ in range(105)]

for _ in range(n):
	a, b = map(int, input().split())
	for i in range(a, a+10):
		for j in range(b, b+10):
			grid[i][j] = 1

print(sum(map(sum, grid)))