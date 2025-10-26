n = int(input())
p = [i for i in range(n)]

def find(x):
    while p[x] != x:
        p[x] = p[p[x]]
        x = p[x]
    return x

def union(a,b):
    a,b = find(a),find(b)
    if a==b: return False
    if a>b:
        p[a] = b
    else:
        p[b] = a
    return True

planets = []
for _ in range(n):
    x,y,z = map(int, input().split())
    planets.append([_,x,y,z])

edges = []
for i in range(3):
    planets.sort(key=lambda x:x[i+1])
    for j in range(n-1):
        edges.append([planets[j][0], planets[j+1][0], abs(planets[j][i+1]-planets[j+1][i+1])])


edges.sort(key=lambda x: x[2])
ct = 0
ans = 0
for u,v,c in edges:
    if ct==n-1: break
    a,b = find(u), find(v)
    if union(a,b):
        ans+=c
        ct+=1

print(ans)