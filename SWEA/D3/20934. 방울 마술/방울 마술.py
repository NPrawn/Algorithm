T = int(input())
ans = []
for _ in range(T):
	a, k = input().split()
	k = int(k)
	if k==0:
		ans.append(a.find('o'))
	elif a=='.o.':
		if k%2==0:
			ans.append(1)
		else:
			ans.append(0)
	else:
		if k%2==0:
			ans.append(0)
		else:
			ans.append(1)

for i,e in enumerate(ans, start=1):
	print(f'#{i} {e}')