import heapq

dxs = [1, 0, -1, 0]
dys = [0, 1, 0, -1]
inf = float('inf')

def solution(board):
    n = len(board)
    dist = [[[inf for _ in range(4)] for _ in range(n)] for _ in range(n)]
    q = []

    for d in range(4):
        dist[0][0][d] = 0
        heapq.heappush(q, (0, 0, 0, d))

    while q:
        w, x, y, d = heapq.heappop(q)

        if dist[x][y][d] != w:
            continue

        for nd in range(4):
            nx = x + dxs[nd]
            ny = y + dys[nd]

            if not (0 <= nx < n and 0 <= ny < n):
                continue

            if board[nx][ny] == 1:
                continue

            nw = 100 if nd == d else 600
            cost = w + nw

            if dist[nx][ny][nd] <= cost:
                continue

            dist[nx][ny][nd] = cost
            heapq.heappush(q, (cost, nx, ny, nd))

    return min(dist[n - 1][n - 1])