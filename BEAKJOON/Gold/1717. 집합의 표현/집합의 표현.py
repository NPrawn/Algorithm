n, m = map(int, input().split())
p = [i for i in range(n+1)]
ans = []

def find(x):
    while p[x] != x:
        p[x] = p[p[x]]
        x = p[x]
    return x

def union(a, b):
    a = find(a)
    b = find(b)

    if a > b:
        p[a] = b
    else:
        p[b] = a

for _ in range(m):
    cmd = list(map(int, input().split()))
    if cmd[0]==0:
        union(cmd[1], cmd[2])
    else:
        a = find(cmd[1])
        b = find(cmd[2])
        ans.append('YES' if a==b else 'NO')

for e in ans:
    print(e)