import heapq

n, m = map(int, input().split())
adj = [[] for _ in range(n+1)]
inf = float('inf')
dist = [inf for _ in range(n+1)]

for _ in range(m):
    u, v, w = map(int, input().split())
    adj[u].append([w,v])
    adj[v].append([w,u])

dist[1] = 0
q = []
heapq.heappush(q, (0, 1))
path = [0 for _ in range(n+1)]

while q:
    w, now = heapq.heappop(q)
    if w != dist[now]: continue

    for nw, nxt in adj[now]:
        if dist[nxt] <= dist[now] + nw: continue
        dist[nxt] = dist[now] + nw
        heapq.heappush(q, (dist[nxt], nxt))
        path[nxt] = now

ans = []
a = 1
b = n
while b != a:
    ans.append(b)
    b = path[b]

ans.append(b)
ans = ans[::-1]
k = dist[n]
idx = 1
now = 1
nxt = ans[idx]
idx+=1
mx = 0
st = None
en = None
while now != n:
    for nw, next in adj[now]:
        if next != nxt: continue
        if mx < nw:
            mx = nw
            st = now
            en = nxt
        now = nxt
        nxt = ans[idx]
        idx+=1
        if idx == len(ans): idx-=1

for i in range(len(adj[st])):
    nw = adj[st][i][0]
    nxt = adj[st][i][1]
    if nxt!=en: continue
    adj[st][i][0] *= 2

dist = [inf for _ in range(n+1)]
dist[1] = 0
q = []
heapq.heappush(q, (0, 1))

while q:
    w, now = heapq.heappop(q)
    if w != dist[now]: continue

    for nw, nxt in adj[now]:
        if dist[nxt] <= dist[now] + nw: continue
        dist[nxt] = dist[now] + nw
        heapq.heappush(q, (dist[nxt], nxt))

print(abs(k-dist[n]))