n = int(input())
arr = [0] + list(map(int, input().split()))

dp = [arr[i] for i in range(n+1)]
for i in range(1, n+1):
    l, r = 0, i
    while l<=r:
        dp[i] = max(dp[l]+dp[r], dp[i])
        l+=1
        r-=1

print(dp[n])