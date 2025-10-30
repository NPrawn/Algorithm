n = int(input())
arr = [0] + list(map(int, input().split()))
ans = [i for i in range(0,n+1)]

for i in range(1, n+1):
	for j in range(i, i-arr[i], -1):
		ans[j], ans[j-1] = ans[j-1], ans[j]
	ans[i-arr[i]] = i

print(*ans[1:])