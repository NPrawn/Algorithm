T = int(input())
ans = []
for _ in range(T):
	n = int(input())
	ans.append(n//3)

for i,e in enumerate(ans):
	print(f'#{i+1} {e}')