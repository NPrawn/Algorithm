V, E = map(int, input().split())
p = [i for i in range(V+1)]

def find(x):
    while p[x] != x:
        p[x] = p[p[x]]
        x = p[p[x]]
    return x

def union(a, b):
    a = find(a)
    b = find(b)

    if a>b:
        p[a] = b
    else:
        p[b] = a

edges = []
for _ in range(E):
    A,B,C = map(int, input().split())
    edges.append([A,B,C])

edges.sort(key= lambda x: x[2])
ans = 0

ct = 0
for A,B,C in edges:
    if ct == V-1: break
    a = find(A)
    b = find(B)
    if a==b: continue
    union(a,b)
    ans+=C
    ct+=1

print(ans)