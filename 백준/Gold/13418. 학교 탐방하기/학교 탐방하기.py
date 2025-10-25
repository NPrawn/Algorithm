n, m = map(int, input().split())
p = [i for i in range(n+1)]

def find(x):
    while p[x] != x:
        p[x] = p[p[x]]
        x = p[x]
    return x

def union(a,b):
    a,b = find(a),find(b)
    if a>b:
        p[a] = b
    else:
        p[b] = a

def mst(edges):
    global p
    p = [i for i in range(n+1)]
    ct = 0
    res = 0
    tree = []
    for A,B,c in edges:
        if ct == n: break
        a,b = find(A),find(B)
        if a==b: continue
        union(a,b)
        ct+=1
        res+=c
        tree.append([A,B,c])
    return tree

edges = []
edges.append(list(map(int, input().split())))
for _ in range(m):
    edges.append(list(map(int, input().split())))

edges.sort(key=lambda x: x[2])
mx = mst(edges)
edges.reverse()
mn = mst(edges)

t,r = 0, 0
for a,b,c in mx:
    if c==0: t+=1
for a,b,c in mn:
    if c==0: r+=1

print(t**2 - r**2)