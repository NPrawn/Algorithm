n = int(input())
arr = list(map(int, input().split()))
arr.sort()

def can(d: int) -> bool:
    i, j = 0, n
    cnt = 0
    while i < n and j < len(arr):
        if arr[j] - arr[i] >= d:
            cnt += 1
            i += 1
            j += 1
        else:
            j += 1
    return cnt >= n

lo, hi = 0, arr[-1] - arr[0]+1
while lo+1 < hi:
    mid = (lo + hi) // 2
    if can(mid):
        lo = mid
    else:
        hi = mid

print(lo)