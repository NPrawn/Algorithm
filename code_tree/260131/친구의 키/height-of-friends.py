from collections import deque

n, m = map(int, input().split())
adj = [[] for _ in range(n + 1)]
indeg = [0 for _ in range(n + 1)]
ans = []

for i in range(m):
	u, v = map(int, input().split())
	adj[u].append(v)
	indeg[v] += 1
	
q = deque()
for i in range(1, n+1):
	if indeg[i] == 0: q.append(i)

while q:
	now = q.popleft()
	ans.append(now)
	for a in adj[now]:
		indeg[a] -= 1
		if indeg[a] == 0:
			q.append(a)

print(*ans)