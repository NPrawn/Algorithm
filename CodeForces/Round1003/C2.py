import bisect
T = int(input())

ans = []
for _ in range(T):
    n, m = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    b.sort()
    a[0] = min(a[0], b[0]-a[0])
    for i in range(n-1):
        possible = []
        if a[i] <= a[i+1]: possible.append(a[i+1])
        j = bisect.bisect_left(b, a[i]+a[i+1])
        if j==m: j-=1
        if a[i] <= b[j]-a[i+1]: possible.append(b[j]-a[i+1])
        if len(possible) > 0: a[i+1] = min(possible)
        if a[i] > a[i+1]:
            ans.append('no')
            break
    if len(ans) == _: ans.append('yes')
for e in ans:
    print(e)