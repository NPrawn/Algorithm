n = int(input())
arr = list(map(int, input().split()))

s = [0 for _ in range(n + 1)]
for i in range(n):
    s[i+1] = s[i] + arr[i]

mn = [0 for _ in range(n+1)]
mx = [0 for _ in range(n+1)]

mn[n] = mx[n] = s[n]

for i in range(n-1, -1, -1):
    mn[i] = min(mn[i+1], s[i])
    mx[i] = max(mx[i+1], s[i])

ans = max(s) - min(s) + 1

left_min = left_max = 0
for i in range(n):
    diff = -2 * arr[i]

    low = min(left_min, mn[i+1] + diff)
    high = max(left_max, mx[i+1] + diff)

    ans = max(ans, high - low + 1)

    left_min = min(left_min, s[i+1])
    left_max = max(left_max, s[i+1])

print(ans)