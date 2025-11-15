T = int(input())
ans = []
for _ in range(T):
	n = int(input())
	arr = [-1] + list(map(int, input().split())) + [0]
	empty = n+1
	res = []
	while True:
		if empty == n+1:
			for i in range(1, n+1):
				if arr[i] != i:
					arr[empty] = arr[i]
					arr[i] = 0
					empty = i
					res.append(i)
					break
			else:
				break
		k = arr.index(empty)
		arr[empty] = empty
		arr[k] = 0
		empty = k
		res.append(k)
	ans.append(res)
	
for e in ans:
	if len(e) == 0: print(0); print()
	else:
		print(len(e))
		print(*e)