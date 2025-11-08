T = int(input())
d = {'red': 1, 'purple': 2, 'blue': 3, 'green': 4, 'yellow': 5, 'orange': 6}
ans = []
for _ in range(T):
	a, b = input().split()
	a, b = d[a], d[b]
	if a==b: ans.append('E')
	elif abs(a-b) == 1 or (a==1 and b==6) or (a==6 and b==1): ans.append('A')
	elif abs(a-b) == 3: ans.append('C')
	else: ans.append('X')
	
for e in ans:
	print(e)