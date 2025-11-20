T = int(input())
for tc in range(1, T+1):
	ans = 0
	for a in list(map(int, input().split())):
		if a%2==1: ans += a
	
	print(f'#{tc} {ans}')