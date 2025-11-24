n, m = map(int, input().split())
k = int(input())

grid = [list(input()) for _ in range(n)]
ans = []

ps_j = [[0 for _ in range(m+1)] for _ in range(n+1)]
ps_i = [[0 for _ in range(m+1)] for _ in range(n+1)]
ps_o = [[0 for _ in range(m+1)] for _ in range(n+1)]

for i in range(1, n+1):
	for j in range(1, m+1):
		ps_j[i][j] = ps_j[i-1][j] + ps_j[i][j-1] - ps_j[i-1][j-1]
		ps_i[i][j] = ps_i[i - 1][j] + ps_i[i][j - 1] - ps_i[i - 1][j - 1]
		ps_o[i][j] = ps_o[i - 1][j] + ps_o[i][j - 1] - ps_o[i - 1][j - 1]
		if grid[i-1][j-1]=='J': ps_j[i][j]+=1
		if grid[i-1][j-1]=='O': ps_o[i][j]+=1
		if grid[i-1][j-1]=='I': ps_i[i][j]+=1

for tc in range(k):
	sr,sc, er,ec = map(int, input().split())
	sr-=1; sc-=1
	res = []
	res.append(ps_j[er][ec] + ps_j[sr][sc] - ps_j[er][sc] - ps_j[sr][ec])
	res.append(ps_o[er][ec] + ps_o[sr][sc] - ps_o[er][sc] - ps_o[sr][ec])
	res.append(ps_i[er][ec] + ps_i[sr][sc] - ps_i[er][sc] - ps_i[sr][ec])
	ans.append(res)

for e in ans:
	print(*e)
	