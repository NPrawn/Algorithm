import math

T = int(input())

for t in range(T):
    x, y = map(int, input().split())
    d = y - x
    k = int(math.floor(math.sqrt(d)))
    ans = 0
    if d==k*k: ans = 2*k-1
    elif d <= k*k+k: ans = 2*k
    else: ans = 2*k+1

    print(ans)