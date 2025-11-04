T = int(input())
ans = []
for _ in range(T):
	n = int(input())
	arr = list(map(int, input().split()))
	res = float('inf')
	for i in range(1, n-1):
		ct = 0
		for a, b in zip(arr[:i]+arr[i+1:-1], arr[1:i]+arr[i+1:]):
			ct+=abs(b-a)
		res = min(ct,res)
	ans.append(res)

for e in ans:
	print(e)