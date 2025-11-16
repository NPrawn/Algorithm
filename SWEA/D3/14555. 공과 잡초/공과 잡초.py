T = int(input())
ans = []
for _ in range(T):
	s = input()
	ct = 0
	for a, b in zip(s[:-1], s[1:]):
		if a=='(' and b==')':
			ct+=1
		if a=='|' and b==')':
			ct+=1
		if a=='(' and b=='|':
			ct+=1
	
	ans.append(ct)

for i, e in enumerate(ans):
	print(f'#{i+1} {e}')