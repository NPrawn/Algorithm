T = int(input())
ans = []
for _ in range(T):
	a,b,c,d = map(int, input().split())
	s1 = set(range(a,b))
	s2 = set(range(c,d))
	s = s1 & s2
	ans.append(len(s))

for i, e in enumerate(ans):
	print(f'#{i+1} {e}')