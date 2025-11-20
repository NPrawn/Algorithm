T = int(input())
for tc in range(1, T+1):
	n = int(input())
	arr = list(map(int, input().split()))
	mx = [0 for _ in range(n)]
	mx[-1] = arr[-1]
	for i in range(n-2,-1,-1):
		mx[i] = max(mx[i+1], arr[i])
	amount = 0
	cost = 0
	res = 0
	for i in range(n):
		if arr[i] < mx[i]:
			cost += arr[i]
			amount += 1
		elif arr[i]==mx[i]:
			res += amount * arr[i]
			amount = 0
	print(f'#{tc} {res-cost}')