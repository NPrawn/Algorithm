import math
from functools import reduce

T = int(input())
res = []
for _ in range(T):
    n = int(input())
    p = list(map(int, input().split()))
    s = list(map(int, input().split()))
    ans = []
    for i in range(n):
        ans.append(math.lcm(p[i],s[i]))
    for i in range(n):
        if reduce(math.gcd, ans[:i+1]) != p[i]: 
            res.append("NO")
            break
        if reduce(math.gcd, ans[i:]) != s[i]:
            res.append("NO")
            break
    if len(res) == _: res.append("YES")
    print()
    print(ans)
    print()

for e in res:
    print(e)