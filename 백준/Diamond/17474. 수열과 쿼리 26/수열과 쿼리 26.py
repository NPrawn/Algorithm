inf = float('inf')
n = int(input())
mx1 = [0 for _ in range(4 * n)]
mx2 = [-inf for _ in range(4 * n)]
sm = [0 for _ in range(4 * n)]
mxct = [0 for _ in range(4 * n)]
arr = [0] + list(map(int, input().split()))


def build(node, s, e):
    if s == e:
        v = arr[s]
        mx1[node] = v
        mx2[node] = -inf
        mxct[node] = 1
        sm[node] = v
        return
    mid = (s + e) // 2
    build(node * 2, s, mid)
    build(node * 2 + 1, mid + 1, e)
    pull(node)


def pull(node):
    left = node * 2
    right = node * 2 + 1

    sm[node] = sm[left] + sm[right]

    if mx1[left] == mx1[right]:
        mx1[node] = mx1[left]
        mxct[node] = mxct[left] + mxct[right]
        mx2[node] = max(mx2[left], mx2[right])

    elif mx1[left] > mx1[right]:
        mx1[node] = mx1[left]
        mxct[node] = mxct[left]
        mx2[node] = max(mx2[left], mx1[right])

    else:
        mx1[node] = mx1[right]
        mxct[node] = mxct[right]
        mx2[node] = max(mx1[left], mx2[right])


def apply(node, x):
    if mx1[node] <= x:
        return
    sm[node] -= (mx1[node] - x) * mxct[node]
    mx1[node] = x


def push(node):
    left = node * 2
    right = node * 2 + 1

    if mx1[left] > mx1[node]:
        apply(left, mx1[node])
    if mx1[right] > mx1[node]:
        apply(right, mx1[node])


def update(node, s, e, l, r, x):
    if e < l or r < s or mx1[node] <= x:
        return

    if l <= s and e <= r and mx2[node] < x:
        apply(node, x)
        return

    if s == e:
        return

    push(node)
    mid = (s + e) // 2
    left = node * 2
    right = node * 2 + 1

    update(left, s, mid, l, r, x)
    update(right, mid + 1, e, l, r, x)
    pull(node)


def get_max(node, s, e, l, r):
    if e < l or r < s:
        return -inf
    if l <= s and e <= r:
        return mx1[node]

    push(node)
    mid = (s + e) // 2
    left = node * 2
    right = node * 2 + 1

    return max(get_max(left, s, mid, l, r), get_max(right, mid + 1, e, l, r))


def get_sum(node, s, e, l, r):
    if e < l or r < s:
        return 0
    if l <= s and e <= r:
        return sm[node]

    push(node)
    mid = (s + e) // 2
    left = node * 2
    right = node * 2 + 1

    return get_sum(left, s, mid, l, r) + get_sum(right, mid + 1, e, l, r)


build(1, 1, n)
m = int(input())
out = []
for _ in range(m):
    cmds = list(map(int, input().split()))
    if cmds[0] == 1:
        update(1, 1, n, cmds[1], cmds[2], cmds[3])
    elif cmds[0] == 2:
        out.append(str(get_max(1, 1, n, cmds[1], cmds[2])))
    else:
        out.append(str(get_sum(1, 1, n, cmds[1], cmds[2])))

print('\n'.join(out))