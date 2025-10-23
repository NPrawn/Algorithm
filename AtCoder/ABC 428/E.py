from collections import deque

n = int(input())
g = [[] for _ in range(n+1)]
for _ in range(n-1):
    a, b = map(int, input().split())
    g[a].append(b)
    g[b].append(a)

def bfs(st):
    q=deque()
    d = [-1 for _ in range(n+1)]
    q.append(st)
    d[st] = 0
    while q:
        cur = q.popleft()
        for nxt in g[cur]:
            if d[nxt] != -1: continue
            d[nxt] = d[cur]+1
            q.append(nxt)
    return d

d1 = bfs(1)
val = max(d1)
for i in range(n,0,-1):
    if d1[i]==val:
        s=i
        break

ds = bfs(s)
val = max(ds)
for i in range(n,0,-1):
    if ds[i]==val:
        t=i
        break

dt = bfs(t)
ans = []
for i in range(1, n+1):
    if ds[i]>dt[i]: ans.append(s)
    elif ds[i]<dt[i]: ans.append(t)
    else: ans.append(max(s,t))

for e in ans:
    print(e)