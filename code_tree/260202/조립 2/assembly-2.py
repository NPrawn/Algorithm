from collections import deque

n, m = map(int, input().split())
adj = [[] for _ in range(n+1)]
deg = [0 for _ in range(n+1)]

for i in range(m):
    a, k = map(int, input().split())
    for e in list(map(int, input().split())):
        adj[e].append(a)
        deg[a] += 1

k = int(input())
arr = list(map(int, input().split()))

q = deque()
for a in arr:
    q.append(a)
    deg[a] = 0

ans = [0 for _ in range(n+1)]
while q:
    now = q.popleft()
    ans[now] += 1
    for e in adj[now]:
        deg[e] -= 1;
        if deg[e]==0:
            q.append(e)

print(sum(ans))
for i in range(n+1):
    if ans[i] != 0: print(i, end=' ')