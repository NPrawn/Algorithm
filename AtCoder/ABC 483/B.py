n, q = map(int, input().split())
K = list(map(int, input().split()))
arr = [i for i in range(1, n+1)]

for k in K:
    tmp = arr[:k]
    tmp.reverse()
    tmp = [-i for i in tmp]
    arr = tmp + arr[k:]

for a in arr:
    print(a)