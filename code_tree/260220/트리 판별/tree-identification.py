from collections import deque, defaultdict

m = int(input())

def solve():
    n = 10000
    adj = defaultdict(lambda : [])
    deg = defaultdict(lambda : 0)
    s = set()
    for _ in range(m):
        a, b = map(int, input().split())
        adj[a].append(b)
        deg[b] += 1
        s.add(a)
        s.add(b)

    root = [i for i in s if deg[i] == 0]
    if len(root) != 1:
        return False

    for i in s:
        if i in root: continue
        if deg[i] != 1: return False
    
    q = deque()
    vis = defaultdict(lambda : False)
    vis[root[0]] = True
    q.append(root[0])
    while q:
        now = q.popleft()
        for nxt in adj[now]:
            if vis[nxt]: continue
            vis[nxt] = True
            q.append(nxt)

    return len(vis) == len(s)

print(1 if solve() else 0)