T = int(input())
for tc in range(1, T+1):
	s = input()
	ans = 1 if s==s[::-1] else 0
	print(f'#{tc} {ans}')