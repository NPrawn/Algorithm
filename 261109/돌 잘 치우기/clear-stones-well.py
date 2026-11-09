from collections import deque

n, k, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]
starts = [[int(x) - 1 for x in input().split()] for _ in range(k)]

stones = []
idx = [[-1] * n for _ in range(n)]
dxs = [1, 0, -1, 0]
dys = [0, 1, 0, -1]

for x in range(n):
    for y in range(n):
        if grid[x][y] == 1:
            idx[x][y] = len(stones)
            stones.append((x, y))

ans = 0
seen = set()

def bfs(mask):
    q = deque()
    visited = [[0] * n for _ in range(n)]
    cand = set()
    res = 0

    for x, y in starts:
        if visited[x][y]: continue
        visited[x][y] = 1
        q.append((x, y))

    while q:
        x, y = q.popleft()
        res += 1

        for dx, dy in zip(dxs, dys):
            nx = x + dx
            ny = y + dy

            if not (0 <= nx < n and 0 <= ny < n): continue
            if visited[nx][ny]: continue

            if grid[nx][ny] == 1:
                i = idx[nx][ny]

                if not (mask & (1 << i)):
                    cand.add(i)
                    continue

            visited[nx][ny] = 1
            q.append((nx, ny))

    return res, cand


def dfs(mask, cnt):
    global ans

    if mask in seen: return
    seen.add(mask)

    res, cand = bfs(mask)
    ans = max(ans, res)

    if cnt == m: return

    for i in cand:
        dfs(mask | (1 << i), cnt + 1)


dfs(0, 0)
print(ans)