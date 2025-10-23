T = int(input())
ans = []

for _ in range(T):
    n, k = map(int, input().split())
    arr = list(map(int, input().split()))
    vis = [0 for _ in range(k)]
    cnt = k
    ct = 0

    for x in arr:
        if 0<= x < k and vis[x]==0:
            vis[x]=1
            cnt-=1
        elif x==k:
            ct+=1
    ans.append(max(cnt, ct))

for e in ans:
    print(e)