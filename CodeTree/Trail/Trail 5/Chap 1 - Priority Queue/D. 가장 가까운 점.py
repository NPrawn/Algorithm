import heapq

n, m =  map(int, input().split())
q = []
for _ in range(n):
	x,y = map(int,input().split())
	heapq.heappush(q, [x+y,x,y])

for _ in range(m):
	s,x,y = heapq.heappop(q)
	x+=2; y+=2
	heapq.heappush(q, [x+y,x,y])

ans = heapq.heappop(q)
print(*ans[1:])