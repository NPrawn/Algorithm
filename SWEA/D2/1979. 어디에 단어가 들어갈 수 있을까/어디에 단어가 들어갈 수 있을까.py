T = int(input())
for tc in range(1, T+1):
	n, k = map(int, input().split())
	grid = [input().split() for _ in range(n)]
	ans = 0
	for e in grid:
		ans += ''.join(e).split('0').count('1'*k)
	for e in zip(*grid):
		ans += ''.join(e).split('0').count('1' * k)
	print(f'#{tc} {ans}')
