from itertools import combinations

n, m, d = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]
grid.append([0 for _ in range(m)])
ans = -float('inf')

for lst in combinations([i for i in range(m)], 3):
    ngrid = [[0 for _ in range(m)] for _ in range(n+1)]
    for i in range(n+1):
        for j in range(m):
            ngrid[i][j] = grid[i][j]
    for l in lst:
        ngrid[-1][l] = 2
    res = 0

    while True:
        check = 0
        for i in range(n):
            for j in range(m):
                check+=ngrid[i][j]
        if check==0: break

        for i in range(m):
            if ngrid[-1][i] != 2: continue
            tx = ty = -1
            td = float('inf')
            for y in range(m-1, -1, -1):
                for x in range(n-1, -1, -1):
                    if ngrid[x][y] == 0: continue
                    nd = abs(n-x) + abs(i-y)
                    if nd > d: continue
                    if nd<=td: tx, ty, td = x, y, nd
            if tx != -1 and ty != -1:
                ngrid[tx][ty] = 3

        for x in range(n):
            for y in range(m):
                if ngrid[x][y]==3:
                    ngrid[x][y] = 0
                    res+=1

        for y in range(m):
            if ngrid[n-1][y] == 1: ngrid[n-1][y] = 0

        for x in range(n-2, -1, -1):
            for y in range(m):
                if ngrid[x][y] == 1:
                    ngrid[x+1][y] = 1
                    ngrid[x][y] = 0

    ans = max(ans,res)

print(ans)