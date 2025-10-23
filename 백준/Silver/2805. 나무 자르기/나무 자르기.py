def check(x):
    ct = 0
    for i in arr:
        if i > x:
            ct += i - x
    return ct >= m

n, m = map(int, input().split())
arr = list(map(int, input().split()))

st = 0
en = 2000000000

while st < en:
    mid = (st+en+1) // 2
    if check(mid):
        st = mid
    else:
        en = mid - 1

print(st)