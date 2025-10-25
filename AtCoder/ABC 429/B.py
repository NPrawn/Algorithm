n, m = map(int, input().split())
arr = list(map(int, input().split()))
s = sum(arr)
target = s-m

if target<0: print('No')
else:
    if target in arr:
        print('Yes')
    else:
        print('No')