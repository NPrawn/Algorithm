n = int(input())
grid = [list(map(int, input().split())) for _ in range(n)]
edges = []
p = [i for i in range(n+1)]

def find(x):
    while p[x] != x:
        p[x] = p[p[x]]
        x = p[x]
    return x

def union(a,b):
    a,b = find(a), find(b)
    if a>b:
        p[a] = b
    else:
        p[b] = a

for i in range(n):
    for j in range(n):
        if i>=j: continue
        edges.append([i+1,j+1,grid[i][j]])

edges.sort(key = lambda x: x[2])
ct = 0
ans = 0
for A,B,c in edges:
    if ct == n-1: break
    a = find(A)
    b = find(B)
    if a==b: continue
    ct+=1
    ans+=c
    union(a,b)

print(ans)