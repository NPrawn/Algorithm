import heapq

n = int(input())
arr = list(map(int, input().split()))
q = []
for a in arr:
	heapq.heappush(q, -a)

while len(q) > 1:
	a = -heapq.heappop(q)
	b = -heapq.heappop(q)
	c = a-b
	if c==0: continue
	heapq.heappush(q, -c)

print(-q[0] if q else -1)