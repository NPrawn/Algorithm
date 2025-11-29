T = int(input())
for tc in range(T):
	n, k = map(int, input().split())
	A = list(map(int, input().split()))
	B = list(map(int, input().split()))
	A.sort()
	B.sort(reverse=True)
	a = 0
	b = 0
	ct = 0
	while True:
		if a==n or b==n: break
		if (B[b]+1) * A[a] + B[b] <= k:
			ct+=1
			a+=1
			b+=1
		else: b+=1
	
	print(ct)