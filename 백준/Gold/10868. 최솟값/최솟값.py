def build(node, s, e):
    if s == e:
        seg[node] = arr[s]
        return
    m = (s + e) // 2
    build(node * 2, s, m)
    build(node * 2 + 1, m + 1, e)
    seg[node] = min(seg[node * 2], seg[node * 2 + 1])


def query(node, s, e, l, r):
    if r < s or e < l:
        return float('inf')
    if l <= s and e <= r:
        return seg[node]
    m = (s + e) // 2
    return min(query(node * 2, s, m, l, r), query(node * 2 + 1, m + 1, e, l, r))


n, m = map(int, input().split())
arr = [0]
for _ in range(n):
    arr.append(int(input()))
seg = [0 for _ in range(4 * n)]
build(1, 0, n)

for _ in range(m):
    a, b = map(int, input().split())
    print(query(1, 0, n, a, b))
