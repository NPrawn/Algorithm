idx = 1

while True:
    n = int(input())
    if n == 0: break
    grid = [list(map(int, input().split())) for _ in range(n)]

    Imino = [(0,0), (0,1), (0,2), (0,3)]
    Zmino = [(0,0), (0,1), (1,1), (1,2)]
    Lmino = [(0,0), (0,1), (0,2), (1,2)]
    Tmino = [(0,0), (0,1), (0,2), (1,1)]
    Omino = [(0,0), (1,0), (0,1), (1,1)]
    ans = -float('inf')

    def rotate(mino):
        rotated = []
        for x,y in mino:
            rotated.append((y,-x))
        return rotated

    def count(x,y,mino):
        res = -float('inf')
        for _ in range(4):
            ct = 0
            mino = rotate(mino)
            
            for dx, dy in mino:
                nx, ny = x+dx, y+dy
                if not (0<=nx<n and 0<=ny<n):
                    ct = -float('inf')
                    break
                ct += grid[nx][ny]
            res = max(ct, res)
        return res

    for x in range(n):
        for y in range(n):
            ans = max(ans, count(x,y,Imino), count(x,y,Zmino),
                    count(x,y,Lmino), count(x,y,Tmino), count(x,y,Omino))
    
    print(f"{idx}. {ans}")
    idx+=1