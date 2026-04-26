from collections import deque

n, m = map(int, input().split())
arr = [(-1, -1)]

for i in range(m):
    a, b = map(int, input().split())
    arr.append((a,b))

ans = 0

def check(mid):
    adj = [[] for _ in range(n+1)]
    deg = [0 for _ in range(n+1)]
    vis = [False for _ in range(n+1)]
    for i in range (1, mid+1):
        a, b = arr[i]
        adj[a].append(b)
        deg[b] += 1
    
    q = deque()
    for i in range(1, n+1):
        if deg[i] == 0: q.append(i)
    
    while q:
        now = q.popleft()
        vis[now] = True
        for a in adj[now]:
            deg[a] -= 1
            if deg[a] == 0:
                q.append(a)
    
    for i in range(1, n+1):
        if not vis[i]:
            return True
    
    return False

lo, hi = 1, m
while lo <= hi:
    mid = (lo + hi) // 2
    
    if check(mid):
        ans = mid
        hi = mid - 1
    else:
        lo = mid + 1

print('Consistent' if ans == 0 else ans)