N = int(input())
p = [i for i in range(N+1)]
edges = []

def find(x):
    while p[x] != x:
        p[x] = p[p[x]]
        x = p[x]
    return x

def union(a,b):
    a = find(a)
    b = find(b)
    if a>b:
        p[a] = b
    else:
        p[b] = a

for i in range(1,N+1):
    c = int(input())
    edges.append([0,i,c])

grid = [list(map(int, input().split())) for _ in range(N)]
for i in range(N):
    for j in range(N):
        if i>=j: continue
        edges.append([i+1,j+1,grid[i][j]])

ans = 0
ct = 0
edges.sort(key = lambda x: x[2])

for A,B,c in edges:
    if ct==N: break
    a = find(A)
    b = find(B)
    if a==b: continue
    union(a,b)
    ct+=1
    ans+=c

print(ans)