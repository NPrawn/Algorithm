T = int(input())
ans = []
for _ in range(T):
	n = int(input())
	arr = list(map(int, input().split()))
	res = []
	used = [0 for _ in range(2*n)]
	for i in range(2*n):
		if used[i]: continue
		k = arr[i]//3*4
		for j in range(i, 2*n):
			if used[j]: continue
			if k==arr[j]:
				res.append(arr[i])
				used[i] = 1
				used[j] = 1
				break
	
	ans.append(res)

for i, e in enumerate(ans, start=1):
	print(f'#{i} ', end='')
	print(*e)