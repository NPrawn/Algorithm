n, k, b = map(int, input().split())
arr = [1 for _ in range(n+1)]
for _ in range(b):
	a = int(input())
	arr[a] = 0

t = sum(arr[1:k])
l, r = 1, k
ans = 0
while r<=n:
	t += arr[r]
	ans = max(ans, t)
	t -= arr[l]
	l+=1; r+=1

print(k-ans)