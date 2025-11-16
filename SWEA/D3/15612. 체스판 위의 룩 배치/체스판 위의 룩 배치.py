T = int(input())
ans = []
for _ in range(T):
	grid=[list(input()) for _ in range(8)]
	ok = True
	for i in range(8):
		row = grid[i]
		col = []
		for j in range(8):
			col.append(grid[j][i])
		if row.count('O')!=1: ok=False
		if col.count('O')!=1: ok=False
	
	ans.append('yes' if ok else 'no')
for i,e in enumerate(ans):
	print(f'#{i+1} {e}')