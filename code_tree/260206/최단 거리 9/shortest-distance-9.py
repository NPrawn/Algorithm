import heapq
inf = float('inf')

n, m = map(int, input().split())
adj = [[] for _ in range(n+1)]
d = [inf for _ in range(n+1)]
path = [0 for _ in range(n+1)]

for _ in range(m):
    u, v, w = map(int, input().split())
    adj[u].append((w,v))
    adj[v].append((w,u))

st, en = map(int, input().split())
d[st] = 0
q = []
heapq.heappush(q, (0, st))

while q:
    w, now = heapq.heappop(q)
    if w != d[now]: continue

    for nw, nxt in adj[now]:
        if d[nxt] <= d[now] + nw: continue
        d[nxt] = d[now] + nw
        path[nxt] = now
        heapq.heappush(q, (d[nxt], nxt))

ans = []
ans.append(en)
print(d[en])
while en != st:
    en = path[en]
    ans.append(en)

for a in ans[::-1]:
    print(a, end=' ')