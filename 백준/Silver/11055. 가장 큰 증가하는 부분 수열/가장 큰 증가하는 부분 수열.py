n = int(input())
arr = list(map(int, input().split()))

dp = [0 for _ in range(n)]
for i in range(n):
    mx = 0
    for j in range(i):
        if arr[j]<arr[i]:
            mx = max(mx, dp[j])
    dp[i] = (mx + arr[i])

print(max(dp))