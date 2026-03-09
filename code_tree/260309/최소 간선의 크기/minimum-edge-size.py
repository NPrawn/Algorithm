import heapq

n, m = map(int, input().split())
a, b = map(int, input().split())

p = [i for i in range(n+1)]

def find(x):
    while p[x] != x:
        p[x] = p[p[x]]
        x = p[x]
    return x

def union(a, b):
    a = find(a)
    b = find(b)
    
    if a < b:
        p[a] = b
    else:
        p[b] = a

q = []
for _ in range(m):
    u, v, w = map(int, input().split())
    heapq.heappush(q, (-w, u, v))

ans = 0
while True:
    w, u, v = heapq.heappop(q)
    w = -w
    union(u, v)
    if find(a) == find(b):
        ans = w
        break

print(ans)