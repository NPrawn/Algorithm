import heapq

n = int(input())
arr = list(input().split())
adj = [[] for _ in range(n+1)]
origindeg = [0 for _ in range(n+1)]

idx = 1
for e in arr:
    if e=='<':
        adj[idx].append(idx+1)
        origindeg[idx+1] += 1
    else:
        adj[idx+1].append(idx)
        origindeg[idx] += 1
    idx+=1

q = []
deg = origindeg[:]
for i in range(1, n+1):
    if deg[i] == 0: heapq.heappush(q, i)
ans1 = [0 for _ in range(n+1)]

ct = 1
while q:
    now = heapq.heappop(q)
    ans1[now] = ct
    ct+=1
    for e in adj[now]:
        deg[e] -= 1
        if deg[e] == 0:
            heapq.heappush(q, e)

q = []
deg = origindeg[:]

for i in range(1, n+1):
    if deg[i] == 0:
        heapq.heappush(q, -i)

ans2 = [0 for _ in range(n+1)]
ct = 1
while q:
    now = -heapq.heappop(q)
    ans2[now] = ct
    ct+=1
    for a in adj[now]:
        deg[a] -= 1
        if deg[a] == 0:
            heapq.heappush(q, -a)

for a in ans1[1:]:
    print(f"{a:0>3}",end='')
print()
for a in ans2[1:]:
    print(f"{a:0>3}",end='')