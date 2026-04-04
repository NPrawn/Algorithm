n, q = map(int, input().split())
grid = [0 for _ in range(1000005)]
arr = list(map(int, input().split()))
for a in arr:
	grid[a] = 1
s = [grid[0]]
for a in grid[1:]:
	s.append(s[-1]+a)

ans = []
for _ in range(q):
	a, b = map(int, input().split())
	if a == 0:
		ans.append(s[b])
	else:
		ans.append(s[b]-s[a-1])

for e in ans:
	print(e)