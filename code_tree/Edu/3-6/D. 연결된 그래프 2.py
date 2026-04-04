from collections import deque

n, m = map(int, input().split())
adj = [[] for _ in range(n+1)]
for _ in range(m):
	a,b = map(int,input().split())
	adj[a].append(b)

ans = [0]
for st in range(1, n+1):
	ct = 0
	q = deque()
	vis = [0 for _ in range(n+1)]
	q.append(st)
	vis[st] = 1
	while q:
		u = q.popleft()
		for v in adj[u]:
			if vis[v]: continue
			ct+=1
			q.append(v)
			vis[v]=1
	ans.append(ct)

mx = max(ans)
lst = []
for i, a in enumerate(ans):
	if a==mx: lst.append(i)

print(*lst)