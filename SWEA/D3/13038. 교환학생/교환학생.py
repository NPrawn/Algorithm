T = int(input())
ans = []
for _ in range(T):
	n = int(input())
	arr = list(map(int, input().split()))
	res = float('inf')
	for i in range(7):
		idx = i
		ct = 0
		day = 0
		while ct<n:
			ct+=arr[idx]
			idx+=1
			day+=1
			if idx==7: idx=0
		res = min(res, day)
	ans.append(res)

for i, e in enumerate(ans):
	print(f'#{i+1} {e}')