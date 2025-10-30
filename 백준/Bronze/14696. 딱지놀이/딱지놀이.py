from collections import Counter

n  = int(input())
ans = []

for _ in range(n):
	A = Counter(map(int, input().split()[1:]))
	B = Counter(map(int, input().split()[1:]))
	check = False
	for i in range(4,0,-1):
		if A[i]>B[i]:
			ans.append('A')
			check = True
			break
		elif B[i]>A[i]:
			ans.append('B')
			check = True
			break
	
	if check: continue
	ans.append('D')

for e in ans:
	print(e)