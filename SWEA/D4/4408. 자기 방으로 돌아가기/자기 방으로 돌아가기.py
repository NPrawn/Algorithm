T = int(input())
for tc in range(1, T+1):
	n = int(input())
	board = [0 for _ in range(205)]
	for _ in range(n):
		a, b = map(int, input().split())
		if a>b: a,b = b,a
		if b%2==0: b-=1
		if a%2==0: a-=1
		a//=2
		b//=2
		for i in range(a, b+1):
			board[i] += 1
	
	print(f'#{tc} {max(board)}')