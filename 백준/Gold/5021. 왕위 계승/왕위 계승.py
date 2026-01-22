from collections import defaultdict, deque

n, m = map(int, input().split())
King = input()
deg = defaultdict(lambda: 0)
P = defaultdict(lambda: [])
C = defaultdict(lambda: [])

for _ in range(n):
    c, p1, p2 = input().split()
    C[p1].append(c)
    C[p2].append(c)
    P[c].append(p1)
    P[c].append(p2)
    deg[c] += 1

rate = defaultdict(lambda: -1)
rate[King] = 1
ans = [0, '']

def f(candi):
    total = 0
    for p in P[candi]:
        if rate[p] == -1: f(p)
        total += rate[p]
    rate[candi] = total / 2

for _ in range(m):
    candi = input()
    f(candi)
    if ans[0] < rate[candi]:
        ans = [rate[candi], candi]

print(ans[1])