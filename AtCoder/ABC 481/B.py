n, k = map(int, input().split())
a = list(map(int, input().split()))
ans = 0

for i in range(n):
    if a[i] == k:
        ans += 1

for i, j in zip(a[:-1], a[1:]):
    if i < k < j or j < k < i:
        ans += 1

print(ans)