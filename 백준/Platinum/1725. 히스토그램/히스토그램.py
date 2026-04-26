def build(node, s, e):
    if s == e:
        seg[node] = s
        return
    m = (s + e) // 2
    build(node * 2, s, m)
    build(node * 2 + 1, m + 1, e)
    L = seg[node * 2]
    R = seg[node * 2 + 1]
    seg[node] = L if arr[L] <= arr[R] else R


def query(node, s, e, l, r):
    if r < s or e < l:
        return 0
    if l <= s and e <= r:
        return seg[node]
    m = (s + e) // 2
    a = query(node * 2, s, m, l, r)
    b = query(node * 2 + 1, m + 1, e, l, r)
    if a == 0: return b
    if b == 0: return a
    return a if arr[a] <= arr[b] else b


n = int(input())
arr = [0]
for _ in range(n):
    arr.append(int(input()))
seg = [0 for _ in range(4 * n)]
build(1, 0, n)
stk = [(1, n)]
ans = 0
while stk:
    l, r = stk.pop()
    if l > r: continue
    m = query(1, 0, n, l, r)
    ans = max(ans, arr[m] * (r - l + 1))
    stk.append((l, m - 1))
    stk.append((m + 1, r))

print(ans)
