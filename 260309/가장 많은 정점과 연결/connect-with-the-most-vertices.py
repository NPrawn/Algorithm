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
s = set()
for i in range(1, n+1):
    a = find(i)
    if a in s: continue
    lst.append((arr[a], i))

lst.sort()
q, now = lst[0]
ans = q
for w, nxt in lst[1:]:
    a = find(now)
    b = find(nxt)
    if a==b: continue
    union(a, b)
    ans += w

print(ans if ans <= k else 'NO')

