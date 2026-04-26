n = int(input())
arr = list(map(int, input().split())) + [0,0,0,0,0,0,0]

ans = 0
for i in range(n):
	if arr[i] == 0: continue
	if arr[i+1] == 0:
		ans += 3*arr[i]
		arr[i] = 0
		continue
	if arr[i+2] == 0:
		k = min(arr[i], arr[i+1])
		ans += 5*k
		arr[i] -= k
		arr[i+1] -= k
		ans += 3*arr[i]
		ans += 3*arr[i+1]
		arr[i] = 0
		arr[i+1] =0
		continue
	if arr[i+1] > arr[i+2]:
		k = min(arr[i], arr[i+1] - arr[i+2])
		ans += 5*k
		arr[i] -= k
		arr[i+1] -= k
	k = min(arr[i], arr[i+1], arr[i+2])
	ans += 7*k
	arr[i] -= k
	arr[i+1] -= k
	arr[i+2] -= k
	ans += arr[i] * 3
	arr[i] = 0
print(ans)