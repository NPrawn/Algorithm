T = int(input())
ans = []
for _ in range(T):
	n = int(input())
	a, b = n*10, n*9
	ans.append([a,b])

for i, e in enumerate(ans):
	print(f'#{i+1} {e[0]} {e[1]}')