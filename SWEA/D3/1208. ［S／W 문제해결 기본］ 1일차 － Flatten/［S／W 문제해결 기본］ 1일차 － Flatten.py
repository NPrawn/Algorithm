T = 10
for tc in range(1, T+1):
	k = int(input())
	arr = list(map(int, input().split()))
	for i in range(k):
		mx = max(arr)
		mn = min(arr)
		if mx==mn: break
		a = arr.index(mx)
		b = arr.index(mn)
		arr[a]-=1
		arr[b]+=1
	
	ans = max(arr) - min(arr)
	print(f'#{tc} {ans}')