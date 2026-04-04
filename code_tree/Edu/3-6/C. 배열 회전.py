n, m, k = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

layers = min(n, m) // 2

for s in range(layers):
    top, left = s, s
    bottom, right = n - 1 - s, m - 1 - s

    lst = []

    for j in range(left, right + 1):
        lst.append(grid[top][j])

    for i in range(top + 1, bottom):
        lst.append(grid[i][right])

    for j in range(right, left - 1, -1):
        lst.append(grid[bottom][j])

    for i in range(bottom - 1, top, -1):
        lst.append(grid[i][left])

    L = len(lst)
    r = k % L
    rotated = lst[r:] + lst[:r]

    idx = 0

    for j in range(left, right + 1):
        grid[top][j] = rotated[idx]; idx += 1

    for i in range(top + 1, bottom):
        grid[i][right] = rotated[idx]; idx += 1

    for j in range(right, left - 1, -1):
        grid[bottom][j] = rotated[idx]; idx += 1

    for i in range(bottom - 1, top, -1):
        grid[i][left] = rotated[idx]; idx += 1

for row in grid:
    print(*row)