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

ans = 0
s = set()
mn = float('inf')
for e in p[1:]:
    a = find(e)
    if a in s: continue
    s.add(a)
    ans += arr[a]
    mx = min(mn, arr[a])

if len(s) % 2 == 1:
    ans += mn
print(ans if ans <= k else 'NO')
