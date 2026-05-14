from collections import deque

def solution(rectangle, characterX, characterY, itemX, itemY):
    grid = [[0 for _ in range(105)] for _ in range(105)]

    for x1, y1, x2, y2 in rectangle:
        x1 *= 2
        y1 *= 2
        x2 *= 2
        y2 *= 2

        for x in range(x1, x2 + 1):
            for y in range(y1, y2 + 1):
                grid[x][y] = 1

    for x1, y1, x2, y2 in rectangle:
        x1 *= 2
        y1 *= 2
        x2 *= 2
        y2 *= 2

        for x in range(x1 + 1, x2):
            for y in range(y1 + 1, y2):
                grid[x][y] = 0

    sx = characterX * 2
    sy = characterY * 2
    ex = itemX * 2
    ey = itemY * 2

    dist = [[-1 for _ in range(105)] for _ in range(105)]

    q = deque()
    q.append((sx, sy))
    dist[sx][sy] = 0

    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]

    while q:
        x, y = q.popleft()

        if x == ex and y == ey:
            return dist[x][y] // 2

        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]

            if nx < 0 or nx >= 105 or ny < 0 or ny >= 105:
                continue

            if grid[nx][ny] == 0:
                continue

            if dist[nx][ny] != -1:
                continue

            dist[nx][ny] = dist[x][y] + 1
            q.append((nx, ny))