from collections import deque, defaultdict

n = int(input())
names = input().split()
names.sort()

idx = {name: i for i,name in enumerate(names)}

m = int(input())
adj = [[] for _ in range(n)]
indeg = [0 for _ in range(n)]

for _ in range(m):
    a, b = input().split()
    adj[idx[b]].append(idx[a])
    indeg[idx[a]] += 1

roots = [names[i] for i in range(n) if indeg[i] == 0]
roots.sort()

ans = [[] for _ in range(n)]

q = deque()
for a in roots:
    q.append(idx[a])

while q:
    now = q.popleft()
    for a in adj[now]:
        indeg[a]-=1
        if indeg[a]==0:
            ans[now].append(a)
            q.append(a)

print(len(roots))
print(*roots)

for name in names:
    i = idx[name]
    childs = sorted([names[j] for j in ans[i]])
    print(name, len(childs), *childs)