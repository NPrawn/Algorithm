T = int(input())
ans = []
for _ in range(T):
	s = input()
	mn = int(s)
	mx = int(s)
	for i in range(len(s)):
		for j in range(i+1, len(s)):
			if i==0 and s[j]=='0': continue
			tmp = list(s[:])
			tmp[i], tmp[j] = tmp[j], tmp[i]
			mn = min(mn, int(''.join(tmp)))
			mx = max(mx, int(''.join(tmp)))

	ans.append([mn, mx])

for i, e in enumerate(ans):
	print(f'#{i+1} ', end='')
	print(*e)