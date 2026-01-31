from collections import deque

n, m = map(int, input().split())
adj = [[] for _ in range(n)]
for _ in range(m):
	a, b = map(int, input().split())
	adj[a].append(b)
	adj[b].append(a)

vis = [0 for _ in range(n)]

def dfs(u, depth):
	if depth==4:
		return True
	vis[u] = True
	for v in adj[u]:
		if vis[v]: continue
		if dfs(v, depth+1):
			vis[u] = False
			return True
	
	vis[u] = False
	return False

for st in range(n):
	if dfs(st, 0):
		ans = 1
		break
else:
	ans = 0

print(ans)