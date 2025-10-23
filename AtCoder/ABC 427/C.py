n, m = map(int, input().split())
graph = [[0 for _ in range(n+1)] for _ in range(n+1)]

for _ in range(m):
    u, v = map(int, input().split())
    graph[v][u] = 1

arr = list(range(1,n+1))
ans = float('inf')
for mask in range(1, (1<<n)-1):
    subset1 = [arr[i] for i in range(n) if mask & (1<<i)]
    subset2 = [arr[i] for i in range(n) if not (mask & (1<<i))]
    ct = 0
    for a in subset1:
        for b in subset1:
            if a<=b: continue
            if graph[a][b]==1: ct+=1

    for a in subset2:
        for b in subset2:
            if a<=b: continue
            if graph[a][b]==1: ct+=1
    ans = min(ans, ct)

print(ans)