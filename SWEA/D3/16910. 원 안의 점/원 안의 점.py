T = int(input())
ans = []
for _ in range(T):
	n = int(input())
	ct = 0
	for i in range(n+1):
		for j in range(n+1):
			if i**2 + j**2 <= n**2:
				if i==0 and j==0: ct+=1
				elif i==0 or j==0: ct+=2
				else: ct+=4
	ans.append(ct)

for i, e in enumerate(ans):
	print(f'#{i+1} {e}')