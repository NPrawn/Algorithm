n = int(input())
arr = [0] + list(map(int, input().split()))
t = int(input())

for _ in range(t):
	gen, num = map(int, input().split())
	if gen==1:
		for i in range(num, n+1, num):
			arr[i] = 1 if arr[i]==0 else 0
	if gen==2:
		l, r = num, num
		while arr[l]==arr[r]:
			if l==1 or r==n: break
			r+=1
			l-=1
		if arr[l] != arr[r]:
			r-=1
			l+=1
		for i in range(l, r+1):
			arr[i] = 1 if arr[i]==0 else 0
			

for i in range(1, n+1):
	print(arr[i], end=' ')
	if i%20==0: print()