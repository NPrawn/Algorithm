T = int(input())
ans = []
for _ in range(T):
	b,w,x,y,z = map(int, input().split())
	
	if b>w:
		b, w = w, b
		x, y = y, x
	res = -float('inf')
	for i in range(b+1):
		ct_x = i
		ct_z = b-i
		ct_y = w - (b-i)
		ct_z += b-i
		res = max(res, x*ct_x + y*ct_y + z*ct_z)
	ans.append(res)
	
for e in ans:
	print(e)