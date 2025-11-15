T = int(input())
ans = []
for _ in range(T):
	S = list(input())
	E = list(input())
	while len(E) > len(S):
		if E[-1] == 'X':
			E.pop()
		else:
			E.pop()
			E = E[::-1]
	
	ans.append(f'#{_+1} Yes' if E==S else f'#{_+1} No')
	
for e in ans:
	print(e)