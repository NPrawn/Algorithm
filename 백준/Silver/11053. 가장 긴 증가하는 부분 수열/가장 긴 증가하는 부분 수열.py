n = int(input())
arr = list(map(int, input().split()))

dp = [1]
for i in range(1, n):
    mx = max([dp[j] for j in range(i) if arr[i] > arr[j]], default=0)
    dp.append(mx+1)

print(max(dp))