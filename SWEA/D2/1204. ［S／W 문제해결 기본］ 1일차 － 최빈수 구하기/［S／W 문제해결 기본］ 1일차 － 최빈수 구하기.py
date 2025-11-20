T = int(input())
for tc in range(1, T+1):
	n = int(input())
	counter = [0 for _ in range(101)]
	for a in list(map(int, input().split())):
		counter[a] += 1
	mx = max(counter)
	for i in range(100,-1,-1):
		if counter[i] == mx:
			print(f'#{tc} {i}')
			break