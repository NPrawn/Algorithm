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

for x in list(map(int, input().split())):
    ans = lower_bound(x)
    if ans < n and arr[ans] == x:
        print(ans+1)
    else:
        print(-1)