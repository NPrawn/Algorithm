m = int(input())
a, b = map(int, input().split())

def lower_bound(x):
    l, r = 1, m
    ct = 0
    while l<=r:
        ct+=1
        mid = (l+r) // 2
        if mid == x: return ct
        elif mid < x: l = mid + 1
        else: r = mid - 1
    return ct

mn = float('inf')
mx = -float('inf')
for x in range(a, b+1):
    ct = lower_bound(x)
    mn = min(mn, ct)
    mx = max(mx, ct)

print(mn, mx)