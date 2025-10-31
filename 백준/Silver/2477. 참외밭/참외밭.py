k = int(input())
lines = []

for _ in range(6):
	lines.append(list(map(int, input().split())))

x_mx = -1
y_mx = -1

for idx, v in enumerate(lines):
	if v[0] in [1,2]:
		if x_mx == -1:
			x_mx = idx
		if lines[x_mx][1] < v[1]:
			x_mx = idx
	else:
		if y_mx == -1:
			y_mx = idx
		if lines[y_mx][1] < v[1]:
			y_mx = idx

a = lines[x_mx][1]
b = lines[y_mx][1]
c = min(lines[(x_mx-1)%6][1], lines[(x_mx+1)%6][1])
d = min(lines[(y_mx-1)%6][1], lines[(y_mx+1)%6][1])

print((a*c + (b-c)*d) * k)