import sys
from collections import deque

input = sys.stdin.readline

n = int(input().strip())
words = [input().strip() for _ in range(n)]

letters = set()
for w in words:
    letters.update(w)

# 그래프 구성
adj = {ch: set() for ch in letters}
indeg = {ch: 0 for ch in letters}

# 인접 단어 비교로 제약 추출
for i in range(n - 1):
    a, b = words[i], words[i + 1]
    m = min(len(a), len(b))

    j = 0
    while j < m and a[j] == b[j]:
        j += 1

    if j == m:
        if len(a) > len(b):
            print(-1)
            sys.exit(0)
        continue

    u, v = a[j], b[j]
    if v not in adj[u]:
        adj[u].add(v)
        indeg[v] += 1

q = deque([ch for ch in letters if indeg[ch] == 0])
order = []
ambiguous = False

while q:
    if len(q) > 1:
        ambiguous = True

    cur = q.popleft()
    order.append(cur)

    for nxt in adj[cur]:
        indeg[nxt] -= 1
        if indeg[nxt] == 0:
            q.append(nxt)

if len(order) != len(letters):
    print(-1)
elif ambiguous:
    print("inf")
else:
    print("".join(order))
