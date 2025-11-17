T = int(input())
ans = []
for tc in range(1, T+1):
	n = int(input())
	res = 'No'
	for i in range(1, 10):
		if n%i==0 and n//i<10:
			res = 'Yes'
	
	ans.append(f'#{tc} {res}')

for e in ans:
	print(e)