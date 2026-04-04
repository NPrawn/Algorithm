def build(node, s, e):
    if s == e:
        seg[node] = arr[s]
        return
    m = (s+e) // 2
    build(node*2, s, m)
    build(node*2 + 1, m+1, e)
    seg[node] = seg[node*2] + seg[node*2 + 1]

def propagate(node, s, e):
    if lazy[node] != 0:
        seg[node] += (e - s + 1) * lazy[node]

        if s != e:
            lazy[node*2] += lazy[node]
            lazy[node*2 + 1] += lazy[node]

        lazy[node] = 0

def update_range(node, s, e, l, r, val):
    propagate(node, s, e)
    if r < s or e < l:
        return

    if l <= s and e <= r:
        lazy[node] += val
        propagate(node, s, e)
        return

    m = (s+e) // 2
    update_range(node*2, s, m , l, r, val)
    update_range(node*2 + 1, m+1, e, l, r, val)
    seg[node] = seg[node*2] + seg[node*2 + 1]

def query(node, s, e, l, r):
    propagate(node, s, e)

    if r < s or e < l:
        return 0
    if l <= s and e <= r:
        return seg[node]

    m = (s+e) // 2
    return query(node*2, s, m, l, r) + query(node*2 + 1, m+1, e, l, r)

n, m, k = map(int, input().split())
arr = [0] + list(int(input()) for _ in range(n))
seg = [0 for _ in range(4*n)]
lazy = [0 for _ in range(4*n)]
build(1, 0, n)

for _ in range(m + k):
    cmds = list(map(int, input().split()))
    if cmds[0] == 1:
        update_range(1, 0, n, cmds[1], cmds[2], cmds[3])
    else:
        print(query(1, 0, n, cmds[1], cmds[2]))