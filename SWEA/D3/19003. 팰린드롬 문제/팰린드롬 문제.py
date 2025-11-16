T = int(input())
ans = []
for _ in range(T):
	n, m = map(int, input().split())
	S = []
	for _ in range(n):
		S.append(list(input()))
	check = [0 for _ in range(n)]
	
	for i in range(n):
		if check[i]: continue
		for j in range(i+1, n):
			if check[j]: continue
			s1 = S[i]
			s2 = S[j]
			if s1==s2[::-1]:
				check[i]=1
				check[j]=1
				break
	ct = 0
	for i in range(n):
		if check[i]: ct+=m
	for i in range(n):
		if check[i]: continue
		s = S[i]
		if s==s[::-1]: ct+=m; break
	ans.append(ct)

for i,e in enumerate(ans):
	print(f'#{i+1} {e}')