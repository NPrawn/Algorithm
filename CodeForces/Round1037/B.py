t = int(input())
res = []
for _ in range(t):
    n, k = map(int, input().split())
    arr = list(map(int, input().split()))
    ct = 0
    ans = 0
    for i in range(n):
        if ct==k-1 and i==n-1 and arr[n-1] == 0:
            ans+=1
        elif ct == k:
            ans +=1
            ct = 0
        elif arr[i] == 0:
            ct += 1
        else:
            ct = 0

    res.append(ans)

for i in res:
    print(i)