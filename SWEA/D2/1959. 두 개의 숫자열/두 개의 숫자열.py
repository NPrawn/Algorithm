T = int(input())
for tc in range(1, T+1):
	n, m = map(int, input().split())
	A = list(map(int, input().split()))
	B = list(map(int, input().split()))
	if n>m: A, B = B, A; n,m = m,n

	ans = -float('inf')
	for i in range(m-n+1):
		res = 0
		for a,b in zip(A, B[i:i+n]):
			res += a*b
		ans = max(ans,res)
	
	print(f'#{tc} {ans}')