n, q = map(int, input().split())
rocks = [0]
for _ in range(n):
	rocks.append(int(input()))

S = [[0,0,0,0] for _ in range(n+1)]
for i in range(1, n+1):
	S[i][1] = S[i-1][1]+(1 if rocks[i]==1 else 0)
	S[i][2] = S[i-1][2]+(1 if rocks[i]==2 else 0)
	S[i][3] = S[i-1][3]+(1 if rocks[i]==3 else 0)
ans = []
for _ in range(q):
	a, b = map(int, input().split())
	q = S[b][1] - S[a-1][1]
	w = S[b][2] - S[a-1][2]
	e = S[b][3] - S[a-1][3]
	ans.append([q,w,e])

for e in ans:
	print(*e)