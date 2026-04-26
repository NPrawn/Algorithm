def build(node, s, e):
    if s==e:
        minseg[node] = arr[s]
        maxseg[node] = arr[s]
        return
    m = (s+e) // 2
    build(node*2, s, m)
    build(node*2 + 1, m+1, e)
    minseg[node] = min(minseg[node*2], minseg[node*2 + 1])
    maxseg[node] = max(maxseg[node*2], maxseg[node*2 + 1])

def minq(node, s, e, l, r):
    if r < s or e < l:
        return float('inf')
    if l<=s and e<=r:
        return minseg[node]

    m = (s+e) // 2
    return min(minq(node*2, s, m, l, r), minq(node*2 + 1, m+1, e, l, r))

def maxq(node, s, e, l, r):
    if r < s or e < l:
        return -float('inf')
    if l<=s and e<=r:
        return maxseg[node]
    m = (s+e) // 2
    return max(maxq(node*2, s, m, l, r), maxq(node*2 + 1, m+1, e, l, r))

n, m = map(int, input().split())
arr = [0]
for _ in range(n):
    arr.append(int(input()))
minseg = [0 for _ in range(4*n)]
maxseg = [0 for _ in range(4*n)]

build(1, 0, n)

for _ in range(m):
    a, b = map(int, input().split())
    print(minq(1, 0, n, a, b), maxq(1, 0, n, a, b))