from collections import deque

n = int(input())
names = input().split()
names.sort()

idx = {name: i for i, name in enumerate(names)}

m = int(input())
adj = [[] for _ in range(n)]
indeg = [0 for _ in range(n)]

for _ in range(m):
    x, y = input().split()
    child = idx[x]
    anc = idx[y]
    adj[anc].append(child)
    indeg[child] += 1

roots = [i for i in range(n) if indeg[i] == 0]
roots_names = [names[i] for i in roots]
roots_names.sort()

indeg2 = indeg[:]
children = [[] for _ in range(n)]

q = deque(sorted(roots, key=lambda i: names[i]))

while q:
    u = q.popleft()
    for v in adj[u]:
        indeg2[v] -= 1
        if indeg2[v] == 0:
            children[u].append(v)
            q.append(v)

ans = []
ans.append(str(len(roots_names)))
ans.append(" ".join(roots_names))

for i in range(n):
    childs = children[i]
    childs.sort(key=lambda x: names[x])
    line = [names[i], str(len(childs))]
    line += [names[c] for c in childs]
    ans.append(" ".join(line))

print('\n'.join(ans))