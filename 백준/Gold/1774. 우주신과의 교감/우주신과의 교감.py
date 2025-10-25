n, m = map(int, input().split())
vertex = []
edges = []
p = [i for i in range(n+1)]

def find(x):
    while p[x] != x:
        p[x] = p[p[x]]
        x = p[x]
    return x

def union(a,b):
    a,b = find(a), find(b)
    if a > b:
        p[a] = b
    else:
        p[b] = a

for _ in range(n):
    a, b = map(int, input().split())
    vertex.append([a,b])

for i in range(n):
    x1, y1 = vertex[i]
    for j in range(i):
        x2, y2 = vertex[j]
        dist = abs((x2-x1)**2 + (y2-y1)**2)
        dist **= 0.5
        edges.append([i+1,j+1,dist])

for _ in range(m):
    a, b = map(int, input().split())
    union(a,b)

edges.sort(key=lambda x: x[2])
ct = 0
ans = 0
for A,B,c in edges:
    if ct==n-1: break
    a,b = find(A),find(B)
    if a==b: continue
    union(a,b)
    ct+=1
    ans+=c
ans = round(ans, 2)
print(f"{ans:.2f}")