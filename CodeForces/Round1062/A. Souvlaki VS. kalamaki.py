T = int(input())
ans = []
for _ in range(T):
	n = int(input())
	arr = list(map(int, input().split()))
	arr.sort()
	for i in range(1, n-1, 2):
		if arr[i]!=arr[i+1]: ans.append('NO'); break
	else:
		ans.append('YES')

for e in ans:
	print(e)