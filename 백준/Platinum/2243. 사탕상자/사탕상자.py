def update(node, s, e, idx, diff):
    if idx < s or e < idx: return
    seg[node] += diff
    if s == e:
        return
    m = (s+e) // 2
    update(node*2, s, m, idx, diff)
    update(node*2 + 1, m+1, e, idx, diff)

def query(node, s, e, k):
    if s == e:
        update(1, 0, n, s, -1)
        return s
    m = (s+e) // 2
    if seg[node * 2] >= k:
        return query(node * 2, s, m, k)
    else:
        return query(node * 2 + 1, m+1, e, k-seg[node*2])

t = int(input())
n = 1000005
seg = [0 for _ in range(4*n)]
for _ in range(t):
    cmds = list(map(int, input().split()))
    if cmds[0] == 2:
        update(1, 0, n, cmds[1], cmds[2])
    else:
        print(query(1, 0, n, cmds[1]))
