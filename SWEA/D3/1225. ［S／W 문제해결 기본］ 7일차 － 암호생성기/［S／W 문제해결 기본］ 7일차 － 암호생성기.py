from collections import deque

for _ in range(10):
	tc = int(input())
	q = deque(list(map(int, input().split())))
	idx = 1
	while True:
		num = q.popleft()
		num -= idx
		idx+=1
		if idx==6: idx=1
		if num<=0: q.append(0); break
		q.append(num)
		
	print(f'#{tc} ', end='')
	print(*q)