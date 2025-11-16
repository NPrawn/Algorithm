T = int(input())
ans = []
for _ in range(T):
	s = list(input())
	ct = s.count('x')
	ans.append('NO' if ct>=8 else 'YES')

for i,e in enumerate(ans):
	print(f'#{i+1} {e}')