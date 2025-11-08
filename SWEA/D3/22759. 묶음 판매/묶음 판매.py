T = int(input())
ans = []

for _ in range(T):
	L, R = map(int, input().split())
	if L < (R + 1) / 2:
		ans.append('no')
	else:
		ans.append('yes')

for e in ans:
	print(e)