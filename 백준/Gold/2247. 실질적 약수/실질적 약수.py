import math

n = int(input())
ans = 0
i = 2
while i<=n:
    q = n//i
    if q <= 1: break
    r = n // q
    s = (i+r) * (r-i+1) // 2
    ans = (ans + (q-1)*s) % 1000000
    i = r+1


print(ans%1000000)