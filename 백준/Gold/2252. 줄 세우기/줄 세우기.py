from collections import deque

n, m = map(int, input().split())
adj = [[] for _ in range(n+1)]
deg = [0 for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    adj[a].append(b)
    deg[b] += 1

ans = []
q = deque()
for i in range(1, n+1):
    if deg[i]==0: q.append(i)

while q:
    now = q.popleft()
    ans.append(now)
    for a in adj[now]:
        deg[a] -= 1
        if deg[a]==0:
            q.append(a)

print(*ans)