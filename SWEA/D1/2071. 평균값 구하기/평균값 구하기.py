T = int(input())
for tc in range(1, T+1):
	arr = list(map(int, input().split()))
	t = sum(arr)
	ans = t/len(arr)
	print(f'#{tc} {ans:.0f}')