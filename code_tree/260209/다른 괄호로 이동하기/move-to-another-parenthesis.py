import heapq

n, a, b = map(int, input().split())
inf = float('inf')
grid = []
dxdy = [(1,0), (0,1), (-1,0), (0,-1)]
for _ in range(n):
    grid.append(list(input()))

mx = 0
for i in range(n):
    for j in range(n):
        dist = [[inf for _ in range(n)] for _ in range(n)]
        dist[i][j] = 0
        q = []
        heapq.heappush(q, (0,i,j))
        while q:
            w, x, y = heapq.heappop(q)
            if w != dist[x][y]: continue
            for dx,dy in dxdy:
                nx, ny = x+dx, y+dy
                if not (0<=nx<n and 0<=ny<n): continue
                nw = a if grid[x][y] == grid[nx][ny] else b
                if dist[nx][ny] <= dist[x][y] + nw: continue
                dist[nx][ny] = dist[x][y] + nw
                heapq.heappush(q, (dist[nx][ny], nx, ny))
        
        for rows in dist:
            for item in rows:
                if item == inf: continue
                mx = max(mx, item)
        
print(mx)
