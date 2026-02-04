n, m = map(int, input().split())
arr = list(map(int, input().split()))

def lower_bound(t):
    l, r = 0, n
    while l < r:
        mid = (l+r) // 2
        if arr[mid] < x:
            l = mid + 1
        else:
            r = mid
    return l

for _ in range(m):
    x = int(input())
    ans = lower_bound(x)
    if (ans < n and arr[ans] == x): print(ans+1)
    else: print(-1)