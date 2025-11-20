T = int(input())
for tc in range(1, T+1):
	stk = []
	for cmd in list(input().split()):
		if cmd=='+' and len(stk)>1:
			a = stk.pop()
			b = stk.pop()
			c = a+b
			stk.append(c)
		elif cmd=='-' and len(stk)>1:
			a = stk.pop()
			b = stk.pop()
			c = b-a
			stk.append(c)
		elif cmd=='*' and len(stk)>1:
			a = stk.pop()
			b = stk.pop()
			c = a * b
			stk.append(c)
		elif cmd=='/' and len(stk)>1:
			a = stk.pop()
			b = stk.pop()
			a, b = b, a
			if b==0:
				stk.clear()
				break
			c = a // b
			stk.append(c)
		elif cmd=='.':
			break
		else:
			if cmd=='+' or cmd=='-' or cmd=='*' or cmd=='/':
				stk.clear()
				break
			cmd = int(cmd)
			stk.append(cmd)
	if len(stk) != 1:
		stk.append('error')
	print(f'#{tc} {stk[-1]}')