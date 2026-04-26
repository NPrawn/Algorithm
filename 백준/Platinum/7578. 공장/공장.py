def update(node, s, e, idx):
    if idx < s or e < idx:
        return
    if s == e:
        seg[node] += 1
        return
    m = (s + e) // 2
    update(node * 2, s, m, idx)
    update(node*2 + 1, m+1, e, idx)
    seg[node] = seg[node * 2] + seg[node*2 + 1]

def query(node, s, e, l, r):
    if r < s or e < l:
        return 0
    if l <= s and e <= r:
        return seg[node]
    m = (s + e)// 2
    return query(node*2, s, m, l, r) + query(node*2 + 1, m+1, e, l, r)

n = int(input())
A = list(map(int, input().split()))
B = list(map(int, input().split()))
d = {}
for i, b in enumerate(B):
    d[b] = i

arr = [d[x] for x in A]
ans = 0
seg = [0 for _ in range(4*n)]

for x in arr:
    if x < n:
        ans += query(1, 1, n, x + 1, n)
    update(1, 1, n, x)

print(ans)