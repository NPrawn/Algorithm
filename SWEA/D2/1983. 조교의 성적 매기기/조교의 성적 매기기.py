T = int(input())
for tc in range(1, T+1):
	n, k = map(int, input().split())
	rank = []
	s = ['A+','A0','A-','B+','B0','B-','C+','C0','C-','D0']
	for i in range(1, n+1):
		a,b,c = map(int, input().split())
		res = 0
		res += a*0.35
		res += b*0.45
		res += c*0.20
		rank.append([res, i])
	
	rank.sort(reverse=True)
	idx = 0
	div = n//10
	for i in range(n):
		rank[i].append(s[i//div])
		if rank[i][1] == k:
			print(f'#{tc} {rank[i][2]}')
			break