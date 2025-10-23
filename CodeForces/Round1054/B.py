T = int(input())
ans = []

for _ in range(T):
    n = int(input())
    arr = list(map(int, input().split()))
    arr.sort()
    res = -float('inf')
    for i in range(0,n,2):
        res = max(abs(arr[i]-arr[i+1]), res)
    ans.append(res)

for e in ans:
    print(e)