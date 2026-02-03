import heapq

n, m = map(int, input().split())
adj = [[] for _ in range(n+1)]
deg = [0 for _ in range(n+1)]

for _ in range(m):
    a, b = map(int, input().split())
    adj[a].append(b)
    deg[b]+=1

q = []
for i in range(1, n+1):
    if deg[i]==0: heapq.heappush(q, i)

ans = []
while q:
    now = heapq.heappop(q)
    ans.append(now)
    for a in adj[now]:
        deg[a]-=1
        if deg[a]==0: heapq.heappush(q, a)

if len(ans) == n:
    print(*ans)
else:
    print(-1)