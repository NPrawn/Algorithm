def build(arr):
    global size, seg
    n = len(arr)
    size = 1
    while size < n:
        size <<= 1
    seg = [0 for _ in range(2*size)]

    for i, v in enumerate(arr):
        seg[size+i] = v
    for i in range(size - 1, 0, -1):
        seg[i] = seg[i << 1] + seg[i << 1 | 1]

def update(idx, val):
    i = size + idx
    seg[i] = val
    i >>= 1
    while i:
        seg[i] = seg[i << 1] + seg[i << 1 | 1]
        i >>= 1

def query(l, r):
    l += size
    r += size
    res = 0
    while l < r:
        if l & 1:
            res += seg[l]
            l += 1
        if r & 1:
            r -= 1
            res += seg[r]
        l >>= 1
        r >>= 1
    return res

n, m, k = map(int, input().split())
arr = [int(input()) for _ in range(n)]
build(arr)

for _ in range(m+k):
    a, b, c = map(int, input().split())
    if a == 1:
        update(b-1, c)
    else:
        print(query(b - 1, c))