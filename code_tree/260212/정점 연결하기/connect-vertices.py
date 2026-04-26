n = int(input())
p = [i for i in range(n+1)]

def find(x):
    while p[x] != x:
        p[x] = p[p[x]]
        x = p[x]
    return x

def union(a, b):
    a, b = find(a), find(b)
    
    if a==b: return
    if a > b:
        p[a] = b
    else:
        p[b] = a

for _ in range(n-2):
    a, b = map(int, input().split())
    union(a,b)

a = find(1)
for b in range(2, n+1):
    if a != find(b):
        print(a, b)
        break