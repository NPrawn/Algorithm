T = int(input())
ans = []
for _ in range(T):
    n = int(input())
    arr = [0] + list(map(int, input().split()))
    mx = arr[1]
    for i in range(1, n+1):
        mx = max(mx, arr[i])
        if i%2==0:
            arr[i] = mx
    ct = 0
    for i in range(1, n):
        if i%2==1:
            if not arr[i] < arr[i+1]:
                ct += arr[i]-arr[i+1]+1
                arr[i] = arr[i+1]-1
        if i%2==0:
            if not arr[i] > arr[i+1]:
                ct += arr[i+1]-arr[i]+1
                arr[i+1] = arr[i]-1
    ans.append(ct)

for e in ans:
    print(e)