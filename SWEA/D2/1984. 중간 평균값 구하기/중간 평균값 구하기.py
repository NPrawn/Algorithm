T = int(input())
for tc in range(1, T+1):
	arr = list(map(int, input().split()))
	arr.sort()
	t = sum(arr[1:len(arr)-1])
	ans = t/(len(arr)-2)
	print(f'#{tc} {ans:.0f}')