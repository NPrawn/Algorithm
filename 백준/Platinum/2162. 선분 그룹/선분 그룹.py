def ccw(a, b, c):
    val = (b[0] - a[0]) * (c[1] - a[1]) - (b[1] - a[1]) * (c[0] - a[0])
    if val > 0:
        return 1
    if val < 0:
        return -1
    return 0


def is_cross(a, b, c, d):
    abc = ccw(a, b, c)
    abd = ccw(a, b, d)
    cda = ccw(c, d, a)
    cdb = ccw(c, d, b)

    if abc * abd == 0 and cda * cdb == 0:
        if a > b:
            a, b = b, a
        if c > d:
            c, d = d, c
        return c <= b and a <= d

    return abc * abd <= 0 and cda * cdb <= 0

def find(x):
    while p[x] != x:
        p[x] = p[p[x]]
        x = p[x]
    return x

def union(a, b):
    a = find(a)
    b = find(b)

    if a==b: return
    if a > b:
        a, b = b, a
    p[b] = a
    ct[a] += ct[b]

n = int(input())
lines = []
p = [i for i in range(n)]
ct = [1 for _ in range(n)]
for i in range(n):
    a, b, c, d = map(int,input().split())
    for idx, line in enumerate(lines):
        if is_cross((a,b), (c,d), (line[0], line[1]), (line[2], line[3])):
            union(i, idx)
    lines.append((a,b,c,d))

for i in range(n):
    find(i)
s = set()
for e in p:
    s.add(e)
print(len(s))
print(max(ct))