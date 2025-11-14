from collections import deque

def solution(storage, requests):
    answer = 0
    n = len(storage)+2
    m = len(storage[0])+2
    grid = [list('0' for _ in range(len(storage[0])+2))]
    for s in storage:
        grid.append(['0'] + list(s) + ['0'])
    grid.append(['0' for _ in range(len(storage[0])+2)])
    
    def bfs(c, grid):
        q = deque()
        vis = [[0 for _ in range(m)] for _ in range(n)]
        q.append([0,0])
        vis[0][0] = 1
        new_grid = [row[:] for row in grid]
        while q:
            x, y = q.popleft()
            for dx, dy in [[1,0],[0,1],[-1,0],[0,-1]]:
                nx, ny = x+dx, y+dy
                if not (0<=nx<n and 0<=ny<m): continue
                if grid[nx][ny] == c:
                    new_grid[nx][ny] = '0'
                    continue
                if grid[nx][ny] != '0': continue
                if vis[nx][ny]: continue
                q.append([nx,ny])
                vis[nx][ny]=1
        return new_grid
    
    for req in requests:
        if len(req)==1:
            grid = bfs(req, grid)
        else:
            c = req[0]
            for i in range(n):
                for j in range(m):
                    if grid[i][j]==c: grid[i][j] = '0'
    
    for i in range(n):
        for j in range(m):
            if grid[i][j]=='0': continue
            answer+=1

    return answer