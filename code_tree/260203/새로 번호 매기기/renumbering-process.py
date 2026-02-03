import heapq

n, m = map(int, input().split())
adj = [[] for _ in range(n+1)]
deg = [0 for _ in range(n+1)]

q = []
for _ in range(m):
    x, y = map(int, input().split())
    adj[x].append(y)
    deg[y] += 1

for i in range(1, n+1):
    if deg[i] == 0: heapq.heappush(q, i)

ans = []
while q:
    now = heapq.heappop(q)
    ans.append(now)
    for a in adj[now]:
        deg[a] -= 1
        if deg[a] == 0:
            heapq.heappush(q, a)

res = [0 for _ in range(n+1)]
if (len(ans) == n):
    for i,a in enumerate(ans, start = 1):
        res[a] = i
    print(*res[1:])
else:
    print(-1)