n, m = map(int, input().split())
arr = list(map(int, input().split()))

for _ in range(m):
    x = int(input())
    l, r = 0, n-1
    ans = -1
    while l <= r:
        mid = (l+r) // 2
        if arr[mid] == x:
            ans = mid + 1
            break
        elif arr[mid] < x: l = mid + 1
        else: r = mid - 1
    
    print(ans)
