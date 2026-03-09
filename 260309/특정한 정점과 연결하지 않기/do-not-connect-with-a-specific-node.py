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
    a, b = map(int, input().split())
    union(a, b)

a, b, k = map(int, input().split())
ans = 1
for i in range(1, n+1):
    if (find(i) != find(a) and find(i) != find(b)):
        ans += 1

print(ans)