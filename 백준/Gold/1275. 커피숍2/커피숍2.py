def build(node, s, e):
    if s==e:
        seg[node] = arr[s]
        return
    m = (s+e) // 2
    build(node*2, s, m)
    build(node*2 + 1, m+1, e)
    seg[node] = seg[node*2] + seg[node*2 + 1]

def update(node, s, e, idx, val):
    if idx < s or e < idx:
        return
    if s == e:
        seg[node] = val
        return
    m = (s+e) // 2
    update(node*2, s, m, idx, val)
    update(node*2 + 1, m+1, e, idx, val)
    seg[node] = seg[node*2] + seg[node*2 + 1]

def query(node, s, e, l, r):
    if r < s or e < l:
        return 0
    if l <= s and e <= r:
        return seg[node]
    m = (s+e) // 2
    return query(node*2, s, m, l, r) + query(node*2 + 1, m+1, e, l, r)

n, q = map(int, input().split())
arr = [0] + list(map(int, input().split()))
seg = [0 for _ in range(4*n)]
build(1, 0, n)
for _ in range(q):
    x, y, a, b = map(int, input().split())
    if x > y:
        x, y = y, x
    print(query(1, 0, n, x, y))
    update(1, 0, n, a, b)