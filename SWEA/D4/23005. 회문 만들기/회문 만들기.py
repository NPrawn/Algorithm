T = int(input())
ans = []
for _ in range(T):
	arr = list(input())
	tmp = []
	idx = []
	for i, a in enumerate(arr):
		if a=='x':
			idx.append(i)
			continue
		tmp.append(a)
	l, r = 0, len(tmp)-1
	ok = True
	while l<=r:
		if tmp[l]!=tmp[r]:
			ok=False
			break
		l+=1
		r-=1
	
	if not ok:
		ans.append(-1)
		continue
	
	i, j = 0, len(arr) - 1
	ct = 0
	while i < j:
		if arr[i] == arr[j]:
			i += 1
			j -= 1
		elif arr[i] == 'x':
			ct += 1
			i += 1
		elif arr[j] == 'x':
			ct += 1
			j -= 1
		else:
			ct = -1
			break
	ans.append(ct)

for e in ans:
	print(e)
	
	