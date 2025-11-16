T = int(input())
S = 'abcdefghijklmnopqrstuvwxyz'
ans = []
for _ in range(T):
	s = input()
	ct = 0
	for i in range(len(s)):
		if S[i] == s[i]: ct+=1
		else: break
	ans.append(ct)

for i,e in enumerate(ans):
	print(f'#{i+1} {e}')