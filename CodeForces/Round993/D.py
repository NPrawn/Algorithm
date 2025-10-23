T = int(input())
ans = []
for _ in range(T):
    n = int(input())
    a = list(map(int,input().split()))
    b = []
    unused = set(range(1, n+1))

    for i in range(0, len(a)):
        if a[i] in unused: 
            b.append(a[i])
            unused.remove(a[i])
        else:
            x = unused.pop()
            b.append(x)
    ans.append(b)
for e in ans:
    print(*e)