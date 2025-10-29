n = int(input())
dp = [0]
for i in range(n):
	arr = list(map(int, input().split()))
	if arr[1] == 0:
		dp.append(arr[0])
		continue
	mx = 0
	for a in arr[2:]:
		mx = max(mx, dp[a])
	dp.append(mx+arr[0])

print(max(dp))