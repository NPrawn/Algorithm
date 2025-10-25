from collections import deque

n, m = map(int, input().split())
g = [[] for _ in range(n+1)]
for _ in range(m):
    u, v = map(int, input().split())
    g[u].append(v)
    g[v].append(u)
s = list(input())

q = deque()
dist = [[] for _ in range(n+1)]
for i in range(n):
    if s[i]=='S':
        q.append([i+1, i+1, 0])
        dist[i+1].append([i+1,0])

while q:
    rt, now, d = q.popleft()
    for nxt in g[now]:
        check = False
        for st, dd in dist[nxt]:
            if len(dist[nxt])==2: check=True; break
            if st==rt: check=True; break
        if check: continue
        dist[nxt].append([rt, d+1])
        q.append([rt,nxt,d+1])

ans = []
for i in range(n):
    if s[i]=='D':
        res = 0
        for rt, d in dist[i+1]:
            res+=d
        ans.append(res)

for e in ans:
    print(e)