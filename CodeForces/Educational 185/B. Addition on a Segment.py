T = int(input())
ans = []
for tc in range(T):
	n = int(input())
	arr = list(map(int, input().split()))
	total = sum(arr)
	t = n - arr.count(0)
	ans.append(min(t, total-(n-1)))
for e in ans:
	print(e)