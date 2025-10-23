n, m, k = map(int, input().split())

arr = [[0] for _ in range(n+1)]
ans = []
for _ in range(k):
    a, b = map(int, input().split())
    arr[a].append(b)
    if len(arr[a]) == m+1: ans.append(a)

print(*ans)