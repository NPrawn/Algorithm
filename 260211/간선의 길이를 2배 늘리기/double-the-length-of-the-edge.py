inf = float('inf')

n, m = map(int, input().split())
g = [[0 for _ in range(n+1)] for _ in range(n+1)]
vis = [False for _ in range(n+1)]
dist = [0 for _ in range(n+1)]
path = [0 for _ in range(n+1)]

ans = 0

for _ in range(m):
    x, y, z = map(int, input().split())
    g[x][y] = z
    g[y][x] = z

def dijk():
    for i in range(1, n+1):
        dist[i] = inf
    dist[1] = 0

    for i in range(1, n+1):
        vis[i] = False
    
    for i in range(1, n+1):
        idx = -1
        for j in range(1, n+1):
            if vis[j]: continue
        
            if idx == -1 or dist[idx] > dist[j]:
                idx = j
        
        vis[idx] = True

        for j in range(1, n+1):
            if g[idx][j] ==0: continue
            if dist[j] <= dist[idx] + g[idx][j]: continue
            dist[j] = dist[idx] + g[idx][j]
            path[j] = idx


dijk()

x = n
vertices = []
vertices.append(x)
while x != 1:
    x = path[x]
    vertices.append(x)

origin = dist[n]
length = len(vertices)
for i in range(length -1, 0, -1):
    x = vertices[i]
    y = vertices[i-1]
    g[x][y] *= 2
    g[y][x] *= 2
    dijk()

    ans = max(ans, dist[n] - origin)
    g[x][y] //= 2
    g[y][x] //= 2

print(ans)