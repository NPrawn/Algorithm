T = int(input())
ans = []
for _ in range(T):
	n, k = map(int, input().split())
	arr = list(map(int, input().split()))
	arr.sort()
	res = float('inf')
	for i in range(n-k+1):
		mx = max(arr[i:i+k])
		mn = min(arr[i:i+k])
		res = min(res, mx-mn)
	
	ans.append(res)

for i, e in enumerate(ans):
	print(f'#{i+1} {e}')