import heapq

n = int(input())
q = []
for _ in range(n):
	a = int(input())
	if a==0:
		if q:
			print(-heapq.heappop(q))
		else:
			print(0)
	else:
		heapq.heappush(q,-a)