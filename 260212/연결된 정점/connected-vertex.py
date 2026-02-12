n, m = map(int, input().split())

p = [i for i in range(n+1)]
ct = [1 for _ in range(n+1)]
def find(x):
    while p[x] != x:
        x = p[x] = p[p[x]]
    return x

def union(a, b):
    a = find(a)
    b = find(b)
    
    if a > b:
        p[a] = b
        ct[b] += ct[a]
    else:
        p[b] = a
        ct[a] += ct[b]

for _ in range(m):
    cmds = list(input().split())
    if cmds[0] == 'x':
        union(int(cmds[1]), int(cmds[2]))
    else:
        k = find(int(cmds[1]))
        print(ct[k])