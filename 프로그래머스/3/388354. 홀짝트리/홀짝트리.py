from collections import deque

def solution(nodes, edges):
    n = len(nodes)
    idx = {label: i for i, label in enumerate(nodes)}

    g = [[] for _ in range(n)]
    deg = [0] * n
    for u, v in edges:
        iu, iv = idx[u], idx[v]
        g[iu].append(iv); g[iv].append(iu)
        deg[iu] += 1; deg[iv] += 1

    val_par = [(label & 1) for label in nodes]

    s = [val_par[i] ^ (deg[i] & 1) for i in range(n)]

    vis = [False] * n
    ans_evenodd = 0
    ans_rev = 0

    for st in range(n):
        if vis[st]:
            continue
        q = deque([st]); vis[st] = True
        c0 = c1 = 0
        while q:
            u = q.popleft()
            if s[u] == 0: c0 += 1
            else: c1 += 1
            for w in g[u]:
                if not vis[w]:
                    vis[w] = True
                    q.append(w)

        if c0 == 1: ans_evenodd += 1
        if c1 == 1: ans_rev += 1

    return [ans_evenodd, ans_rev]
