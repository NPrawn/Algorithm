T = int(input())
ans = []

for _ in range(T):
	n = int(input())
	arr = list(map(int, input().split()))
	x = list(input())
	idx = []
	l, r = 0, 0
	for i in range(n):
		if x[i]=='1':idx.append(i)
		if arr[i] == 1: l = i+1
		if arr[i] == n: r = i+1
	for i in idx:
		if arr[i]==1 or arr[i]==n or i==0 or i==n-1:
			ans.append([-1])
			break
	else:
		res = []
		if l!=1: res.append([l,1])
		if l!=n: res.append([l,n])
		if r!=1: res.append([r,1])
		if r!=n: res.append([r,n])
		res.append([l, r])
		ans.append([len(res)] + res)
		

for e in ans:
	print(e[0])
	for a, b in e[1:]:
		if a > b: a, b = b, a
		print(a, b)