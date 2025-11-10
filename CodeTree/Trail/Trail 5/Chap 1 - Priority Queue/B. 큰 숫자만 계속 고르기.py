import heapq

n, m = map(int, input().split())
arr = list(map(int, input().split()))
q = []
for a in arr:
	heapq.heappush(q, -a)

for _ in range(m):
	k = -heapq.heappop(q)
	k-=1
	heapq.heappush(q, -k)

print(-heapq.heappop(q))