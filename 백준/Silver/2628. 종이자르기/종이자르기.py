m, n = map(int, input().split())
t = int(input())
x_cuts = [0, m]
y_cuts = [0, n]

for _ in range(t):
	a, b = map(int, input().split())
	if a==1: x_cuts.append(b)
	else: y_cuts.append(b)

x_cuts.sort()
y_cuts.sort()

mx1 = 0
mx2 = 0
for a, b in zip(x_cuts[:-1], x_cuts[1:]):
	mx1 = max(mx1, b-a)
for a, b in zip(y_cuts[:-1], y_cuts[1:]):
	mx2 = max(mx2, b-a)

print(mx1*mx2)