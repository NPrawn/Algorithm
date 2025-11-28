A = list(map(int,input()))

ans = []
prev = -1
if len(A)%2==1: ans = [-1]
else:
	for a,b in zip(A[::2], A[1::2]):
		if prev == b:
			ans = [-1]
			break
		if a==0:
			ans = [-1]
			break
		prev = b
		for _ in range(a):
			ans.append(b)

if ans[0] == 0:
	ans = [-1]

for a in  ans:
	print(a, end='')