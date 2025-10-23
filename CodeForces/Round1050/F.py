from collections import deque

T = int(input())
for _ in range(T):
    n = int(input())
    a = [deque(list(map(int, input().split()))[1:]) for i in range(n)]
    a.sort(key=lambda x: -len(x))
    ans=[]
    while a:
        cur = min(a)
        ans += cur
        while a and len(a[-1]) <= len(cur):
            a.pop()
        for i in range(len(a)):
            for j in range(len(cur)):
                a[i].popleft()
    print(*ans)