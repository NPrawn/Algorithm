from collections import deque

n = int(input())
adj = [[] for _ in range(n+1)]
for _ in range(1, n):
    a, b, c = map(int, input().split())
    adj[a].append((c,b))
    adj[b].append((c,a))

def bfs(st):
    dst = [-1 for _ in range(n+1)]
    dst[st] = 0
    q = deque()
    q.append(st)
    while q:
        now = q.popleft()
        for w, nxt in adj[now]:
            if dst[nxt] != -1: continue
            dst[nxt] = dst[now] + w
            q.append(nxt)
    
    return dst

d1 = bfs(1)
st = d1.index(max(d1))
d2 = bfs(st)

print(max(d2))