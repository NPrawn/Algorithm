from collections import deque

T = int(input())
ans = []

for _ in range(T):
	s = deque(list(input()))
	k = int(input())
	arr = list(map(int, input().split()))
	for a in arr:
		if a>0:
			x = a%len(s)
			for _ in range(x):
				s.append(s.popleft())
		if a<0:
			x = abs(a)%len(s)
			for _ in range(x):
				s.appendleft(s.pop())
	ans.append(s)
for e in ans:
	while e:
		print(e.popleft(), end='')
	print()