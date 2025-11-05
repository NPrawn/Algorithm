T = int(input())
ans = []
for _ in range(T):
	n = int(input())
	A = list(map(int, input().split()))
	B = list(map(int, input().split()))
	a = 0
	b = 0
	used = [0 for _ in range(n)]
	res = ['' for _ in range(n)]
	while res.count('A')+res.count('B')<n:
		while used[A[a]-1]:
			a+=1
		res[A[a] - 1] = 'A'
		used[A[a]-1] = 1
		if res.count('A')+res.count('B')==n: break
		while used[B[b]-1]:
			b+=1
		res[B[b] - 1] = 'B'
		used[B[b] - 1] = 1
	ans.append(res)

for e in ans:
	for q in e:
		print(q, end='')
	print()