import heapq

s = int(input())

l, r = 1, s

ans = -float('inf')
while l<=r:
    mid = (l+r) // 2
    if mid * (mid+1) // 2 <= s:
        l = mid + 1
        ans = max(ans, mid)
    else:
        r = mid - 1

print(ans)