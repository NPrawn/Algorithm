N = int(input())
arr = list(map(int, input().split()))
inf = float('inf')

dp = arr[0]
drop = -inf
ans = arr[0]

for i in range(1, N):
    x = arr[i]
    new_dp = max(x, dp+x)
    new_drop = max(drop+x, dp)
    dp, drop = new_dp, new_drop
    ans = max(ans, dp, drop)

print(ans)