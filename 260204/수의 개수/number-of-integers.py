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

def upper_bound(t):
    l, r = 0, n

    while l < r:
        mid = (l+r) // 2
        if arr[mid] <= x:
            l = mid + 1
        else:
            r = mid
    return l

for _ in range(m):
    x = int(input())
    print(upper_bound(x) - lower_bound(x))