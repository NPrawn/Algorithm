n = int(input())
arr = list(map(int, input().split()))

sorted_unique = sorted(set(arr))
compress = {v: i for i, v in enumerate(sorted_unique)}
m = len(sorted_unique)

tree = [0 for _ in range(4*n)]

def update(node, s,e,idx):
    if idx < s or idx > e:
        return

    if s == e:
        tree[node] += 1
        return

    mid = (s+e) // 2
    update(node * 2, s, mid, idx)
    update(node * 2 + 1, mid+1, e, idx)
    tree[node] = tree[node*2] + tree[node*2 + 1]

def query(node, s, e, l, r):
    if r < s or e < l:
        return 0

    if l <= s and e <= r:
        return tree[node]

    mid = (s + e) // 2
    return query(node * 2, s, mid, l, r) + query(node * 2 + 1, mid+1, e, l, r)

ans = 0

for x in arr:
    idx = compress[x]
    if idx + 1 <= m - 1:
        ans += query(1, 0, m-1, idx+1, m-1)

    update(1, 0, m-1,idx)

print(ans)