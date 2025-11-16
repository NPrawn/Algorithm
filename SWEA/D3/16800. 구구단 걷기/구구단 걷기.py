T = int(input())
ans = []
for _ in range(T):
	n = int(input())
	pos = []
	for i in range(1, n+1):
		if i**2 > n : break
		if n%i!=0: continue
		pos.append([i,n//i])
	ct = float('inf')
	for x,y in pos:
		ct = min(ct, x-1 + y-1)
	ans.append(ct)
for i, e in enumerate(ans):
	print(f'#{i+1} {e}')