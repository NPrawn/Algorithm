def check(x):
    arr
    cur = 0
    for i in range(len(arr)):
        cur += arr[i] // x
    return cur >= n

k, n = map(int, input().split())
arr = []
for _ in range(k):
    arr.append(int(input()))
st = 0
en = 0xFFFFFFFF

while st<en:
    mid = (st+en+1)//2
    if check(mid): st = mid
    else: en = mid-1
print(st)