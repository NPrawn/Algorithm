from collections import deque

n, m1, m2 = map(int, input().split())
adj = [[] for _ in range(n+1)]
deg = [0 for _ in range(n+1)]

for i in range(m1):
    a, b = map(int, input().split())
    adj[a].append(b)
    deg[b]+=1

for i in range(m2):
    a, b = map(int, input().split())

q = deque()
for i in range(1, n+1):
    if deg[i] == 0: q.append(i)

ans = []
while q:
    now = q.popleft()
    ans.append(now)
    for a in adj[now]:
        deg[a] -= 1
        if deg[a]==0:
            q.append(a)

print('Yes' if len(ans) == n else 'No')