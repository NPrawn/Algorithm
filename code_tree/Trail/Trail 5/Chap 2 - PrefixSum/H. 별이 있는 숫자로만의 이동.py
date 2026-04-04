n, k = map(int, input().split())
A = [list(map(int, input().split())) for _ in range(n)]
m = 2*n-1
T = [[0]*m for _ in range(m)]

off = n-1
for i in range(n):
	for j in range(n):
		x = i+j
		y = i-j+off
		T[x][y] = A[i][j]

S = [[0]*(m+1) for _ in range(m+1)]
for i in range(m):
	row_sum = 0
	for j in range(m):
		row_sum+=T[i][j]
		S[i+1][j+1] = S[i][j+1] + row_sum
		
def rect_sum(r1,c1,r2,c2):
	r1, c1 = max(0,r1), max(0,c1)
	r2, c2 = min(m-1,r2), min(m-1,c2)
	if r1 > r2 or c1 > c2:
		return 0
	return S[r2 + 1][c2 + 1] - S[r1][c2 + 1] - S[r2 + 1][c1] + S[r1][c1]

ans = 0
for i in range(n):
	for j in range(n):
		x = i+j
		y = i-j+off
		ans = max(ans, rect_sum(x-k,y-k,x+k,y+k))

print(ans)