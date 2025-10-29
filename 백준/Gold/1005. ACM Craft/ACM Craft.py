from collections import deque

T = int(input())
ans = []
for _ in range(T):
	n, k = map(int, input().split())
	D = [0] + list(map(int, input().split()))
	dp = [0 for _ in range(n+1)]
	indeg = [0 for _ in range(n+1)]
	adj = [[] for _ in range(n+1)]
	for i in range(k):
		x, y = map(int ,input().split())
		adj[x].append(y)
		indeg[y] += 1
	target = int(input())
	q = deque()
	for i in range(1, n+1):
		if indeg[i] == 0:
			q.append(i)
			dp[i] = D[i]
	while q:
		now = q.popleft()
		for a in adj[now]:
			indeg[a] -= 1
			dp[a] = max(dp[a], dp[now])
			if indeg[a] == 0:
				q.append(a)
				dp[a] = max(dp[a], dp[now])+D[a]
	
	ans.append(dp[target])
for e in ans:
	print(e)