n, m = map(int, input().split())
arr = [int(input()) for _ in range(n)]

l, r = 0, max(arr)

def check(x):
    ct = 0
    for a in arr:
        ct += a//x
    return ct>=m

ans = -float('inf')
while l<=r:
    mid = (l+r) // 2
    if check(mid):
        ans = max(ans, mid)
        l = mid + 1
    else:
        r = mid - 1
