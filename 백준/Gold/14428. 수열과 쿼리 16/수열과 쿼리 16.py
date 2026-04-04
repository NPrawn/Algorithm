def build(node, s, e):
    if s==e:
        seg[node] = s
        return
    m = (s+e) // 2
    build(node*2, s, m)
    build(node*2 + 1, m+1, e)
    if arr[seg[node * 2]] <= arr[seg[node * 2 + 1]]:
        seg[node] = seg[node*2]
    else:
        seg[node] = seg[node*2 + 1]

def update(node, s, e, idx, val):
    if idx < s or e < idx: return
    if s==e:
        seg[node] = idx
        return
    m = (s+e) // 2
    update(node*2, s, m, idx, val)
    update(node*2 + 1, m+1, e, idx, val)
    if arr[seg[node*2]] <= arr[seg[node*2 + 1]]:
        seg[node] = seg[node*2]
    else:
        seg[node] = seg[node*2 + 1]

def query(node, s, e, l, r):
    if e < l or r < s: return 0
    if l<=s and e<=r:
        return seg[node]
    m = (s+e) // 2
    left = query(node*2, s, m, l, r)
    right = query(node*2+1, m+1, e, l, r)
    if arr[left] <= arr[right]:
        return left
    else:
        return right

n = int(input())
arr = [float('inf')] + list(map(int, input().split()))
seg = [0 for _ in range(4*n)]
build(1, 0, n)
m = int(input())
for _ in range(m):
    cmds = list(map(int, input().split()))
    if cmds[0] == 1:
        arr[cmds[1]] = cmds[2]
        update(1, 0, n, cmds[1], cmds[2])
    else:
        print(query(1, 0, n, cmds[1], cmds[2]))