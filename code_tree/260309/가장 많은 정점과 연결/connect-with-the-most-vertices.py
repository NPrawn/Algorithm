n, m, k = map(int, input().split())
arr = [0] + list(map(int, input().split()))
p = [i for i in range(n+1)]

def find(x):
    while p[x] != x:
        p[x] = p[p[x]]
        x = p[x]
    return x

def union(a, b):
    a = find(a)
    b = find(b)
    if a==b: return
    if arr[a] < arr[b]:
        p[b] = a
    else:
        p[a] = b
    
for _ in range(m):
    a, b = map(int, input().split())
    union(a, b)

for i in range(n+1):
    find(i)

lst = []
for i in range(2, n+1):
    a = find(1)
    b = find(i)
    if a == b: continue
    lst.append((arr[b] + arr[a], i))

lst.sort()

ans = 0
for v, i in lst:
    a = find(1)
    b = find(i)
    if a==b: continue
    union(1, i)
    ans += v

print(ans if ans <= k else 'NO')
