T = int(input())
ans = []
for _ in range(T):
	a, b = map(int, input().split())
	k=a+b
	if k>=24: k-=24
	ans.append(k)

for i, e in enumerate(ans):
	print(f'#{i+1} {e}')