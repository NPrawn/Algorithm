import heapq

n = int(input())
q = []
for _ in range(n):
	cmd = input().split()
	if cmd[0]=='push':
		heapq.heappush(q, -int(cmd[1]))
	elif cmd[0]=='pop':
		print(-heapq.heappop(q))
	elif cmd[0]=='size':
		print(len(q))
	elif cmd[0]=='empty':
		print(0 if q else 1)
	else:
		k = -heapq.heappop(q)
		print(k)
		heapq.heappush(q, -k)
		