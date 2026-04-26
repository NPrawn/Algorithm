from collections import deque

n = int(input())
adj = [[] for _ in range(n+1)]
for _ in range(n-1):
    a, b = map(int, input().split())
    adj[a].append(b)
    adj[b].append(a)

def bfs(st):
    q = deque()
    q.append(st)
    dist = [-1 for _ in range(n+1)]
    dist[st] = 0
    path = [0 for _ in range(n+1)]
    while q:
        now = q.popleft()
        for nxt in adj[now]:
            if dist[nxt] != -1: continue
            dist[nxt] = dist[now] + 1
            path[now] = nxt
            q.append(nxt)
    
    return path, dist

p1, d1 = bfs(1)
st = d1.index(max(d1))
p2, d2 = bfs(st)

print(max(d2)//2 if max(d2)%2 ==0 else max(d2)//2+1)