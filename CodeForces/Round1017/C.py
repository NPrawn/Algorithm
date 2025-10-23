T = int(input())

ans=[]
for _ in range(T):
    n = int(input())
    G = []
    for i in range(n):
        G.append(list(map(int, input().split())))
    res = [0] * (2*n)
    idx = 1
    vis = set()
    for i in range(n):
        res[idx] = G[0][i]
        idx+=1
        vis.add(G[0][i])
    for i in range(1,n):
        res[idx] = G[i][n-1]
        idx+=1
        vis.add(G[i][n-1])
    for i in range(1,(2*n)+1):
        if i in vis:
            continue
        res[0] = i
    ans.append(res)

for list in ans:
    for e in list:
        print(e,end=" ")
    print()