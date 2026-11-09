h, w, n, q = map(int, input().split())
row = []
col = []
for _ in range(n):
    r, c = map(int, input().split())
    row.append(r)
    col.append(c)

row.sort()
col.sort()

def lower_bound(arr, target):
    l, r = 0, len(arr)

    while l < r:
        mid = (l + r) // 2

        if arr[mid] < target:
            l = mid + 1
        else:
            r = mid

    return l

def upper_bound(arr, target):
    l, r = 0, len(arr)

    while l < r:
        mid = (l + r) // 2

        if target < arr[mid]:
            r = mid
        else:
            l = mid + 1

    return l

for _ in range(q):
    cmd, a, b = map(int, input().split())
    if cmd == 1:
        A = lower_bound(row, a)
        B = upper_bound(row, b)
        print(B-A)
    else:
        A = lower_bound(col, a)
        B = upper_bound(col, b)
        print(B-A)
