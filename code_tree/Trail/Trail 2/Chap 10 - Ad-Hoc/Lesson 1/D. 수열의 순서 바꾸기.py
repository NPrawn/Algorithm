n = int(input())
arr = list(map(int, input().split()))

ans = 0
for i in range(n-1, 0, -1):
	if arr[i-1]<arr[i]: continue
	ans = i
	break

print(ans)