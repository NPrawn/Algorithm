T = int(input())
for tc in range(1, T+1):
	n,m,k = map(int, input().split())
	arr = list(map(int, input().split()))
	arr.sort()
	ans = 'Possible'
	for i in range(n):
		t = arr[i]
		amount = t//m*k - i
		if amount>0: continue
		else: ans = 'Impossible'
	
	print(f'#{tc} {ans}')