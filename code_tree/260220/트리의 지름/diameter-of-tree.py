import heapq
inf = float('inf')

n = int(input())
adj = [[] for _ in range(n+1)]
for _ in range(n-1):
    a, b, c = map(int, input().split())
    adj[a].append((c,b))
    adj[b].append((c,a))

def dijk(st):
    d = [inf for _ in range(n+1)]
    q = []
    heapq.heappush(q, (0, st))
    d[st] = 0
    while q:
        w, now = heapq.heappop(q)
        for nw, nxt in adj[now]:
            if d[nxt] <= d[now] + nw: continue
            d[nxt] = d[now] + nw
            heapq.heappush(q, (d[nxt], nxt))
    
    return d

d1 = dijk(1)
st = 0
for e in d1:
    st = max(st, e if e != inf else 0)
st = d1.index(st)
d2 = dijk(st)
ans = 0
for e in d2:
    ans = max(ans, e if e != inf else 0)
print(ans)