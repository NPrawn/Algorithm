a, b, c, d = map(int, input().split())
ans = ''
if a<=c:
	if b<=d:
		ans='No'
	else:
		ans='Yes'
else:
	ans='No'

print(ans)