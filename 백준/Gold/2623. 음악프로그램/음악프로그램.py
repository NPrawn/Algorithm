from collections import deque

n, m = map(int, input().split())
adj = [[] for _ in range(n+1)]
deg = [0 for _ in range(n+1)]
for _ in range(m):
    arr = list(map(int, input().split()))
    for i in range(1, len(arr)-1):
        adj[arr[i]].append(arr[i+1])
    for a in arr[2:]:
        deg[a] += 1
q = deque()
for i in range(1,n+1):
    if deg[i]==0: q.append(i)
ans = []
while q:
    now = q.popleft()
    ans.append(now)
    for a in adj[now]:
        deg[a] -= 1
        if deg[a] == 0: q.append(a)

if len(ans) != n: print(0)
else:
    for e in ans:
        print(e)