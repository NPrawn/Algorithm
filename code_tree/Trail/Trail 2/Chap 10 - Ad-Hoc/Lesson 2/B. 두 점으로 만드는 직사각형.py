min_x = 100
max_x = -100
min_y = 100
max_y = -100
for _ in range(2):
	x1,y1,x2,y2 = map(int, input().split())
	min_x = min(min_x,x1,x2)
	min_y = min(min_y,y1,y2)
	max_x = max(max_x,x1,x2)
	max_y = max(max_y,y1,y2)

print((max_y-min_y)*(max_x-min_x))
