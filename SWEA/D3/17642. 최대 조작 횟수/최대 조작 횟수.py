T = int(input())
ans = []
for _ in range(T):
	a, b = map(int, input().split())
	k = b-a
	if k<0 or k==1: ans.append(-1); continue
	if k==0: ans.append(0); continue
	ans.append(k//2)

for i, e in enumerate(ans):
	print(f'#{i+1} {e}')