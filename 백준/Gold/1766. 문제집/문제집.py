import heapq

n, m = map(int, input().split())
adj = [[] for _ in range(n+1)]
indeg = [0 for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    indeg[b] += 1
    adj[a].append(b)

q = []
for i in range(1, n+1):
    if indeg[i]==0: heapq.heappush(q, i)

ans = []
while q:
    now = heapq.heappop(q)
    ans.append(now)
    for a in adj[now]:
        indeg[a] -= 1
        if indeg[a]==0: heapq.heappush(q, a)

print(*ans)