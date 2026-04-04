from collections import deque

a, b = map(int, input().split())
dist = [float('inf') for _ in range(200000)]
dist[a] = 0
q = deque()
q.append(a)
ans = -1

while q:
	now = q.popleft()
	
	nxt = [now + 1, now - 1]
	nx = now * 2
	if 0 <= nx < len(dist) and dist[nx] > dist[now]:
		dist[nx] = dist[now]
		q.appendleft(nx)
	
	for nx in nxt:
		if 0 <= nx < len(dist) and dist[nx] > dist[now] + 1:
			dist[nx] = dist[now] + 1
			q.append(nx)

print(dist[b])