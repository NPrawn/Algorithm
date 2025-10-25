n, m = map(int, input().split())
p = [i for i in range(n+1)]

def find(x):
    while p[x] != x:
        p[x] = p[p[x]]
        x = p[x]
    return x

def union(a,b):
    a,b = find(a),find(b)
    if a > b:
        p[a] = b
    else:
        p[b] = a

edges = []
for _ in range(m):
    a,b,c = map(int, input().split())
    edges.append([a,b,c])

edges.sort(key=lambda x: x[2])
ct = 0
ans = 0
for A,B,c in edges:
    if ct==n-2: break
    a,b = find(A),find(B)
    if a==b: continue
    ct+=1
    ans += c
    union(a,b)

print(ans)