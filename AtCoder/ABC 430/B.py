n, m = map(int, input().split())
grid = [list(input())for _ in range(n)]
ans = set()
for i in range(n-m+1):
	for j in range(n-m+1):
		key = tuple(''.join(row[j:j+m]) for row in grid[i:i+m])
		ans.add(key)

print(len(ans))