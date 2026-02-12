n, m = map(int, input().split())
p = [i for i in range(n+1)]

def find(x):
    while p[x] != x:
        p[x] = p[p[x]]
        x = p[x]
    return x

def union(a, b):
    a = find(a)
    b = find(b)

    if a > b:
        p[a] = b
    else:
        p[b] = a

for _ in range(m):
    cmd, a, b = map(int, input().split())
    if cmd==0:
        union(a,b)
    else:
        print(1 if find(a) == find(b) else 0)