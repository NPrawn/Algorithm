n, m = map(int, input().split())
arr = list(map(int, input().split()))

def lower_bound(x):
    l, r = 0, n

    while l < r:
        mid = (l+r) // 2
        if arr[mid] < x:
            l = mid + 1
        else:
            r = mid
    return l

def upper_bound(x):
    l, r = 0, n

    while l < r:
        mid = (l+r) // 2
        if arr[mid] <= x:
            l = mid + 1
        else:
            r = mid
    return l

for _ in range(m):
    a, b = map(int, input().split())
    print(upper_bound(b) - lower_bound(a))
