T = int(input())
ans = []
for _ in range(T):
	arr = list(input())
	res = 0
	now = 0
	for a in arr:
		if a=='R':
			now+=1
		else:
			now-=1
		res = max(res, abs(now))
	now = 0
	for a in arr:
		if a == 'L':
			now -= 1
		else:
			now += 1
		res = max(res, abs(now))
	ans.append(res)

for e in ans:
	print(e)