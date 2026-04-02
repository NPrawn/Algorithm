from collections import deque

def solution(n, infection, edges, k):
    g = [[] for _ in range(n)]
    for x, y, t in edges:
        x -= 1
        y -= 1
        t -= 1
        g[x].append((y, t))
        g[y].append((x, t))

    comps = [[] for _ in range(3)]

    for color in range(3):
        vis = [False] * n
        for start in range(n):
            if vis[start]:
                continue

            q = deque([start])
            vis[start] = True
            mask = 0

            while q:
                cur = q.popleft()
                mask |= (1 << cur)

                for nxt, t in g[cur]:
                    if t != color or vis[nxt]:
                        continue
                    vis[nxt] = True
                    q.append(nxt)

            comps[color].append(mask)

    def expand(mask, color):
        nxt = mask
        for comp in comps[color]:
            if mask & comp:
                nxt |= comp
        return nxt

    best = {}
    ans = 1

    def dfs(step, mask):
        nonlocal ans

        if mask in best and best[mask] <= step:
            return
        best[mask] = step

        ans = max(ans, bin(mask).count('1'))
        if step == k or ans == n:
            return

        for color in range(3):
            nxt = expand(mask, color)
            if nxt != mask:
                dfs(step + 1, nxt)

    dfs(0, 1 << (infection - 1))
    return ans