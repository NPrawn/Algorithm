n, m, k = map(int, input().split())
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
    union(a,b)

arr = list(map(int, input().split()))
a = find(arr[0])
ans = 1
for b in arr[1:]:
    if a != find(b): ans = 0

print(ans)