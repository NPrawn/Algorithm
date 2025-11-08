T = int(input())
ans = []

for _ in range(T):
	arr = list(map(int, input().split()))
	total = sum(arr)
	k = max(arr)
	k+=1
	while True:
		if (total+k)%7==0:
			ans.append(k)
			break
		k+=1

for e in ans:
	print(e)