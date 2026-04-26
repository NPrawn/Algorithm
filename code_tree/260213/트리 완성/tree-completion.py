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

    if a==b: return False

    if a > b:
        p[a] = b
    else:
        p[b] = a
    return True

ans = 0
for _ in range(m):
    a, b = map(int, input().split())
    if(not union(a, b)):
        ans += 1

for i in range(1, n+1):
    find(i)
s = set(p[1:])
ans += len(s)-1
print(ans)