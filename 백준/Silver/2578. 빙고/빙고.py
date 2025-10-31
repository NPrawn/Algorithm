grid = [list(map(int, input().split())) for _ in range(5)]
bingo = [[0 for _ in range(5)] for _ in range(5)]


def erase(num):
	for i in range(5):
		for j in range(5):
			if grid[i][j]==num: bingo[i][j]=1

def check():
	ct = 0
	for rows in bingo:
		if sum(rows)==5: ct+=1
	
	for cols in zip(*bingo):
		if sum(cols)==5: ct+=1
	
	if sum(bingo[i][i] for i in range(5))==5: ct+=1
	if sum(bingo[4-i][i] for i in range(5))==5: ct+=1
	if ct>=3: return True
	else: return False

ans = 0
for _ in range(5):
	nums = list(map(int, input().split()))
	for num in nums:
		ans+=1
		erase(num)
		if check():
			break
	if check():
		break

print(ans)