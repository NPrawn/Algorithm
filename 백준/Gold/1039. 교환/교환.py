from collections import deque
arr, k = input().split()
s = list(str(arr))
n = len(s)
k = int(k)
ans = -1
if n==1:
	print(-1)
else:
	vis = [set() for _ in range(k+1)]
	q = deque()
	q.append((s, 0))
	vis[0].add(int(''.join(s)))
	
	while q:
		digits, cnt = q.popleft()
		cur_num = int(''.join(digits))
		
		if cnt == k:
			ans = max(ans, cur_num)
			continue
			
		for i in range(n-1):
			for j in range(i+1, n):
				if i==0 and digits[j]=='0': continue
				nd = digits[:]
				nd[i], nd[j] = nd[j], nd[i]
				nxt = int(''.join(nd))
				
				if nxt not in vis[cnt+1]:
					vis[cnt+1].add(nxt)
					q.append((nd, cnt+1))
	print(ans)