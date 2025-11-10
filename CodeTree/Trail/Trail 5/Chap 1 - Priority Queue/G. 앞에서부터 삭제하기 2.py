n = int(input())
arr = list(map(int, input().split()))

ps = [0 for _ in range(n+1)]
mins = [float('inf') for _ in range(n+1)]
for i in range(n-1, -1, -1):
	ps[i] = ps[i+1] + arr[i]
	mins[i] = min(arr[i], mins[i+1])

ans = 0
for k in range(1, n-1):
	total = ps[k] - mins[k]
	avg = total / (n-k-1)
	ans = max(ans,avg)

print(f"{ans:.2f}")