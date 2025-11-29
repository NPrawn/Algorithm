import math
w, b = map(int, input().split())

w *= 1000
ans = w//b
if w%b==0:
	k = 1
else:
	k = 0
print(math.ceil(w/b)+k)