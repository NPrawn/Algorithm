T = int(input())
for tc in range(T):
	n, h = map(int, input().split())
	ok = True
	cmd = []
	for _ in range(n):
		t, l, u = map(int, input().split())
		cmd.append([t,l,u])
	prev_t = 0
	L = R = h
	for i in range(n):
		nt, l, u = cmd[i]
		t = nt - prev_t
		prev_t = nt
		
		L -= t
		R += t
		
		if R < 1:
			ok = False
			break
		L = max(L, 1)
		L = max(L, l)
		R = min(R, u)
		if L > R:
			ok = False
			break
	
	print('Yes' if ok else 'No')