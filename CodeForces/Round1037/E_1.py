import math

T = int(input())
res = []

for _ in range(T):
    n = int(input())
    a = list(map(int,input().split()))
    s = list(map(int,input().split()))
    if n==1 and a[0] == s[0]:
        res.append("YES")
        continue
    elif n==1 and a[0] != s[0]:
        res.append("NO")
        continue
    d = []
    for i in range(n):
        z = max(a[i], s[i])
        x = min(a[i], s[i])
        if z%x != 0: 
            res.append("NO")
            break
    if len(res) == _: res.append("YES")

for e in res:
    print(e)