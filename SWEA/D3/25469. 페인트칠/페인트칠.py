T = int(input())
ans = []

for _ in range(T):
	h, w = map(int ,input().split())
	grid = [list(input()) for _ in range(h)]
	set_h = set(range(h))
	set_w = set(range(w))
	ct = 0
	for i in range(h):
		for j in range(w):
			if grid[i][j] == '#': continue
			set_h.discard(i)
			set_w.discard(j)
			ct+=1
	if ct == 0: ans.append(min(h,w))
	else:
		ans.append(len(set_h) + len(set_w))

for e in ans:
	print(e)