T = int(input())
ans = []

def find(x):
    while p[x] != x:
        p[x] = p[p[x]]
        x = p[x]
    return x

def union(a, b):
    a = find(a)
    b = find(b)
    if a==b:
        ans.append(ct[a])
    elif a < b:
        p[b] = a
        ct[a] += ct[b]
        ans.append(ct[a])
    else:
        p[a] = b
        ct[b] += ct[a]
        ans.append(ct[b])

for _ in range(T):
    F = int(input())
    d = {}
    n = 0
    p = []
    ct = []

    for __ in range(F):
        a, b = input().split()
        if a not in d:
            d[a] = n
            p.append(n)
            ct.append(1)
            n+=1
        if b not in d:
            d[b] = n
            p.append(n)
            ct.append(1)
            n+=1
        a, b = d[a], d[b]
        union(a,b)

for e in ans:
    print(e)