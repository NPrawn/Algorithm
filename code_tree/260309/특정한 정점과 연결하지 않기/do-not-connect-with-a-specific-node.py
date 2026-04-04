n, m = map(int, input().split())

p = [i for i in range(n+1)]
ct = [1 for _ in range(n+1)]

def find(x):
    while p[x] != x:
        p[x] = p[p[x]]
        x = p[x]
    return x

def union(a, b):
    a = find(a)
    b = find(b)
    
    if a == b:
        return

    if a > b:
        ct[b] += ct[a]
        p[a] = b
    else:
        ct[a] += ct[b]
        p[b] = a

for _ in range(m):
    a, b = map(int, input().split())
    union(a, b)

a, b, k = map(int, input().split())
lst = []
for i in range(1, n+1):
    if (find(i) != find(a) and find(i) != find(b)):
        lst.append((ct[find(i)],i))

lst.sort(reverse=True)
ans = ct[find(a)]
for cnt, i in lst:
    if (k==0): break
    if (find(i) == find(a)): continue
    union(i, a)
    ans += cnt
    k-=1

print(ans)