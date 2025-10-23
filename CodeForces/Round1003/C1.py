T = int(input())

ans = []
for _ in range(T):
    n, m = map(int, input().split())
    a = list(map(int,input().split()))
    b = int(input())
    a[0] = min(a[0], b-a[0])
    for i in range(len(a)-1):
        tmp = b-a[i+1]
        if a[i] > a[i+1] and a[i] > tmp:
            ans.append('no')
            break
        if a[i] > a[i+1] and a[i] <= tmp:
            a[i+1] = tmp
            continue
        if a[i] <= a[i+1] and a[i] > tmp:
            continue
        if a[i] <= a[i+1] and a[i] <= tmp:
            a[i+1] = min(a[i+1], tmp)
            continue
    
    if len(ans) == _:
        ans.append('yes')

for e in ans:
    print(e)