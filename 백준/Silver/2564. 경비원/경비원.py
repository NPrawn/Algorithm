m, n = map(int, input().split())
k = int(input())
shops = []
def f(dir, d):
	if dir == 1:
		return d
	elif dir == 4:
		return m+d
	elif dir == 2:
		return m+n+(m-d)
	else:
		return 2*m + n + (n-d)

for _ in range(k):
	a, b = map(int, input().split())
	shops.append(f(a, b))

x, y = map(int, input().split())
g = f(x,y)

total = 2*(m+n)
ans = 0
for s in shops:
	diff = abs(g-s)
	ans += min(diff, total-diff)
print(ans)