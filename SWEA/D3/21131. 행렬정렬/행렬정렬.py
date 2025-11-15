T = int(input())
ans = []
for _ in range(T):
	n = int(input())
	A = [list(map(int, input().split())) for _ in range(n)]
	ct = 0
	

	
	for i in range(n-1,-1,-1):
		for j in range(n):
			if A[i][j] == i*n+j+1: continue
			for x in range(i+1):
				for y in range(x, i+1):
					A[x][y], A[y][x] = A[y][x], A[x][y]
			ct+=1
	ans.append(ct)
	
for e in ans:
	print(e)