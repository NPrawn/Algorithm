n = int(input())
lines = []
for _ in range(n):
	a, b = map(int, input().split())
	lines.append([a, b])

lines.sort()
inf = float('inf')
mn = inf
mx = -inf
for a, b in lines[1:]:
	mn = min(a, b, mn)
	mx = max(a, b, mx)
res = mx-mn

mn = inf
mx = -inf
lines.sort(key=lambda x:x[1], reverse=True)
for a, b in lines[1:]:
	mn = min(a, b, mn)
	mx = max(a, b, mx)
res = min(res, mx-mn)

print(res)