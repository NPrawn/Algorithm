T = int(input())
for tc in range(1, T+1):
	s = input()
	stk = []
	ans = 1
	for a in s:
		if a not in '(){}': continue
		elif a=='(': stk.append(a)
		elif a=='{': stk.append(a)
		elif a==')' and stk and stk[-1]=='(': stk.pop()
		elif a=='}' and stk and stk[-1]=='{': stk.pop()
		else: ans = 0
	
	if stk: ans=0
	print(f'#{tc} {ans}')