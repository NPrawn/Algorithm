T = int(input())
ans = []
for _ in range(T):
	n = int(input())
	for i in range(1,n,2):
		if 1<<i > n: break
		if n == 1<<i: ans.append('B'); break
	if len(ans)-1==_: continue
	if n%2==0: ans.append('A')
	else: ans.append('B')

for e in ans:
	print(e)