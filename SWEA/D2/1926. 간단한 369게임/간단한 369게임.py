n = int(input())
for i in range(1, n+1):
	arr = list(str(i))
	ct = arr.count('3')
	ct += arr.count('6')
	ct += arr.count('9')
	if ct == 0:
		print(i, end=' ')
	else:
		print('-'*ct, end=' ')