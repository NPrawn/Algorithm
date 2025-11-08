T = int(input())
ans = []

for _ in range(T):
	a = int(input())
	k = a//3
	a %= 3
	if a==1:
		ans.append('impossible')
		continue
	res = ''
	if a==2: res+='BA'
	for _ in range(k):
		res+='BBA'
	ans.append(res)

for e in ans:
	print(e)