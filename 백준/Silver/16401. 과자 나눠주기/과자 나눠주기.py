def check(x):
    ct = 0
    for i in arr:
        ct += i // x
    return ct >= n

n, m = map(int, input().split())
arr = list(map(int,input().split()))

st = 0
en = 1000000000

while st<en:
    mid = (st+en+1)//2
    if check(mid): st = mid
    else: en = mid-1

print(st)