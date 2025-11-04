T = int(input())
ans = []
for _ in range(T):
	arr = list(map(int, input()))
	used = [[] for _ in range(10)]
	for i, a in enumerate(arr):
		used[a].append(i)
	
	ok = True
	for i in range(10):
		n = len(used[i])
		if n==0: continue
		if n==2:
			a, b = used[i]
			if b-a-1==i: continue
		ok = False
		ans.append('no')
		break
	if ok: ans.append('yes')
	
for e in ans:
	print(e)