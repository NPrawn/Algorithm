n, m, k = map(int, input().split())
power = list(map(int, input().split()))
edges = []
for _ in range(m):
    u, v, w = map(int, input().split())
    edges.append([u,v,w])

p = [i for i in range(n+1)]
def find(x):
    while p[x] != x:
        p[x] = p[p[x]]
        x = p[x]
    return x

def union(a,b):
    a,b = find(a),find(b)
    if a==b: return False
    if a > b:
        p[a] = b
    else:
        p[b] = a
    return True

for t in power:
    edges.append([0, t, 0])

edges.sort(key=lambda x: x[2])

ct=0
ans=0
for u,v,w in edges:
    if ct==n: break
    if union(u,v):
        ct+=1
        ans+=w

print(ans)