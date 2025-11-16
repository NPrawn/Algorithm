TC = int(input())
ans = []
for _ in range(TC):
	n, m = map(int, input().split())
	S = list(input().split())
	T = list(input().split())
	Q = int(input())
	res = []
	for _ in range(Q):
		Y = int(input())
		Y-=1
		res.append(S[Y%n] + T[Y%m])
	ans.append(res)

for i, e in enumerate(ans, start=1):
	print(f'#{i} ', end='')
	print(*e)