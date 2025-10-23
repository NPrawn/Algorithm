N, M = map(int, input().split())
grid = [list(input()) for _ in range(N)]
ans = 0

for x in range(N):
    for y in range(M):
        if grid[x][y]!='X': continue
        for dx,dy in [(1,0),(-1,0),(0,1),(0,-1)]:
            nx = x+dx
            ny = y+dy
            if not (0<=nx<N and 0<=ny<M): continue
            if grid[nx][ny] == 'Y': ans+=1

print(ans)