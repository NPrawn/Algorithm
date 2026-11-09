from collections import deque

n, m, s, t = map(int, input().split())
adj = [[] for _ in range(n+1)]
inf = float('inf')

for _ in range(m):
    a, b = map(int, input().split())
    adj[a].append(b)
for i in range(n+1):
    adj[i].sort()

q = deque()
dist = [inf for _ in range(n+1)]

q.append(s)
dist[s] = 0

while q:
    now = q.popleft()

    for i, nxt in enumerate(adj[now]):
        cost = 0 if i == 0 else 1

        if dist[nxt] <= dist[now] + cost:
            continue

        dist[nxt] = dist[now] + cost

        if cost == 0:
            q.appendleft(nxt)
        else:
            q.append(nxt)

print(dist[t] if dist[t] != inf else -1)