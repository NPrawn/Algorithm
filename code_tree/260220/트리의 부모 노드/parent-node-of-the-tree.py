from collections import deque

n = int(input())
adj = [[] for _ in range(n+1)]
for _ in range(n-1):
    a, b = map(int, input().split())
    adj[a].append(b)
    adj[b].append(a)

vis = [False for _ in range(n+1)]
q = deque()
vis[1] = True
p = [0 for _ in range(n+1)]
q.append(1)

while q:
    now = q.popleft()
    for nxt in adj[now]:
        if vis[nxt]: continue
        vis[nxt] = True
        q.append(nxt)
        p[nxt] = now

for ans in p[2:]:
    print(ans)