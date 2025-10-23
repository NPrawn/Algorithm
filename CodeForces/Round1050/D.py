from collections import deque

T = int(input())
res = []
for _ in range(T):
    n = int(input())
    arr = list(map(int,input().split()))
    odd = []
    ans = 0
    for e in arr:
        if e%2==0: ans += e
        else: odd.append(e)
    odd.sort()
    dq = deque(odd)
    if len(odd) == 0: res.append(0); continue
    ans += dq.pop()
    work = True
    while dq:
        work = not work
        if not work:
            dq.popleft()
        else:
            ans += dq.pop()
    res.append(ans)

for e in res:
    print(e)