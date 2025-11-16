T = int(input())
ans = []
for _ in range(T):
	s = list(input())
	n = len(s)//2
	s1 = s[:n]
	s2 = s[n+1:]
	if s1==s1[::-1] and s2==s2[::-1] and s==s[::-1]:
		ans.append('YES')
	else:
		ans.append('NO')

for i, e in enumerate(ans, start=1):
	print(f'#{i} {e}')