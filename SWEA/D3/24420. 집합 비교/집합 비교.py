T = int(input())
ans = []
for _ in range(T):
	n, m = map(int, input().split())
	A = set(list(map(int, input().split())))
	B = set(list(map(int, input().split())))
	
	if A == B:
		ans.append('=')
	else:
		C = A & B
		if C==B:
			ans.append('>')
		elif C==A:
			ans.append('<')
		else:
			ans.append('?')

for e in ans:
	print(e)