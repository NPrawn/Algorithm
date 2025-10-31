m, n = map(int, input().split())
t = int(input())
horizon = []
vertical = []

for _ in range(t):
	a, b = map(int, input().split())
	if a==1: horizon.append(b)
	else: vertical.append(b)

horizon.sort()
vertical.sort()

st = m
res1 = []
while horizon:
	now = horizon.pop()
	res1.append(st-now)
	st = now
res1.append(st)

st = n
res2 = []
while vertical:
	now = vertical.pop()
	res2.append(st-now)
	st = now
res2.append(st)

ans = 0
for a in res1:
	for b in res2:
		ans = max(ans, a*b)

print(ans)