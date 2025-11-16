T = int(input())
ans = []
for _ in range(T):
	n = int(input())
	S = list(input())
	if n%2==1: ans.append('No'); continue
	k = n//2
	if S[:k]==S[k:]: ans.append('Yes')
	else: ans.append('No')
	
for i, e in enumerate(ans):
	print(f'#{i+1} {e}')