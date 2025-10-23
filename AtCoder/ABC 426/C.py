N, Q = map(int, input().split())
p = [i for i in range(N+1)]
ct = [1 for _ in range(N+1)]
ct[0] = 0
ans = []

def find(x):
    while p[x] != x:
        p[x] = p[p[x]]
        x = p[x]
    return x

def union(a, b):
    a = find(a)
    b = find(b)
    
    p[a] = b
    ct[b] += ct[a]
    ct[a] = 0

for _ in range(Q):
    x, y = map(int, input().split())
    cnt = 0
    now = find(x)
    while now <= x:
        cnt += ct[now]
        union(now, y)
        now = find(now-1)
    ans.append(cnt)
    print(p)
    print(ct)
for e in ans:
    print(e)