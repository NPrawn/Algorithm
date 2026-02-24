from collections import deque

n = int(input())
adj = [[] for _ in range(n+1)]
for _ in range(n-1):
    a, b = map(int, input().split())
    adj[a].append(b)
    adj[b].append(a)

q = deque()
q.append(1)
dist = [-1 for _ in range(n+1)]
dist[1] = 0
check = [0 for _ in range(n+1)]
while q:
    now = q.popleft()
    for nxt in adj[now]:
        if dist[nxt] != -1: continue
        dist[nxt] = dist[now] + 1
        check[now] = 1
        q.append(nxt)

ans = 0
for i in range(1, n+1):
    if check[i] == 1: continue
    ans += dist[i]

print(1 if ans%2==1 else 0)