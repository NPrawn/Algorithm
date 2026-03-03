MOD = 1_000_000_007

def build(node, s, e):
    if s==e:
        seg[node] = arr[s] % MOD
        return
    m = (s+e) // 2
    build(node*2, s, m)
    build(node*2+1, m+1, e)
    seg[node] = (seg[node*2] * seg[node*2 + 1]) % MOD

def update(node, s, e, idx, val):
    if idx < s or e < idx:
        return
    if s == e:
        seg[node] = val
        return
    m = (s+e) // 2
    update(node*2, s, m, idx, val)
    update(node*2 + 1, m+1, e, idx, val)
    seg[node] = (seg[node*2] * seg[node*2 + 1]) % MOD

def query(node, s, e, l, r):
    if r < s or e < l:
        return 1
    if l<=s and e<=r:
        return seg[node]
    m = (s+e) // 2
    return (query(node*2, s, m, l, r) * query(node*2 + 1, m+1, e, l, r)) % MOD

n, m, k = map(int, input().split())
arr = [0]
for _ in range(n):
    arr.append(int(input()))

seg = [0 for _ in range(4*n)]
build(1, 0, n)
for _ in range(m+k):
    a, b, c = map(int, input().split())
    if a == 1:
        update(1, 0, n, b, c)
    else:
        print(query(1, 0, n, b, c) % MOD)
