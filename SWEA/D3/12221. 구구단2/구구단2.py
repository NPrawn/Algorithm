T = int(input())
ans = []
for _ in range(T):
	a, b = map(int, input().split())
	if a>9 or b>9: ans.append(-1)
	else: ans.append(a*b)

for i, e in enumerate(ans):
	print(f'#{i+1} {e}')