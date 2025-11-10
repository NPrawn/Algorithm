import heapq

n, m = map(int, input().split())
lst = list(map(int, input().split()))
ans = []
arr = []
q = []
for a in lst:
	if a%10==0: heapq.heappush(q, a)
	else: arr.append(a)
arr.sort()

while q and q[0] == 10:
	ans.append(heapq.heappop(q))

idx = 0
while m>0:
	m-=1
	if q:
		k = heapq.heappop(q)
		if k == 20:
			ans.append(10)
		else:
			heapq.heappush(q, k-10)
		ans.append(10)
	else:
		if idx<len(arr):
			arr[idx]-=10
			ans.append(10)
			if arr[idx] < 10: idx+=1

print(len(ans))