T = int(input())
for tc in range(1, T+1):
	ans = [0 for _ in range(8)]
	coins = [50000,10000,5000,1000,500,100,50,10]
	n = int(input())
	for i in range(8):
		ans[i] += n//coins[i]
		n%=coins[i]
	print(f'#{tc}')
	print(*ans)