import heapq

n, m = map(int, input().split())
adj = [[] for _ in range(n+1)]
deg = [0 for _ in range(n+1)]

q = []
for _ in range(m):
    x, y = map(int, input().split())
    adj[y].append(x)
    deg[x] += 1

for i in range(1, n+1):
    if deg[i] == 0: heapq.heappush(q, -i)

ct = n
ans = [0 for _ in range(n+1)]
while q:
    now = -heapq.heappop(q)
    ans[now] = ct
    ct-= 1
    for a in adj[now]:
        deg[a] -= 1
        if deg[a] == 0:
            heapq.heappush(q, -a)

if sum(ans) == sum(i for i in range(n+1)) :
    print(*ans[1:])
else:
    print(-1)