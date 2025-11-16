T = int(input())
ans = []
for _ in range(T):
	a, b = map(int, input().split())
	if a==b: ans.append(a)
	else: ans.append(1)

for i, e in enumerate(ans):
	print(f'#{i+1} {e}')