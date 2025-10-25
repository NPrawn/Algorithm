import math

T = int(input())
ans = []
for _ in range(T):
    n, q = map(int, input().split())
    arr = list(input())
    lst = list(map(int,input().split()))
    for k in lst:
        if 'B' not in arr:
            ans.append(k)
            continue
        t = 0
        idx = 0
        while k>0:
            if idx==n: idx=0
            a = arr[idx]
            if a=='A': k-=1
            if a=='B': k//=2
            t+=1
            idx+=1
        ans.append(t)

for e in ans:
    print(e)