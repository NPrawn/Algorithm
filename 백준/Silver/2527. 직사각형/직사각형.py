ans = []
for i in range(1,5):
	x1,y1,x2,y2,X1,Y1,X2,Y2 = map(int, input().split())
	
	dx = min(x2, X2) - max(x1,X1)
	dy = min(y2, Y2) - max(y1,Y1)
	
	if dx < 0 or dy < 0:
		ans.append('d')
	elif dx == 0 and dy == 0:
		ans.append('c')
	elif dx == 0 or dy == 0:
		ans.append('b')
	else:
		ans.append('a')
		
for e in ans:
	print(e)