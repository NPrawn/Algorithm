T = int(input())
ans = []

for _ in range(T):
	a, b = map(int, input().split())
	res = 0
	for i in range(1, a+1):
		res+=i
		if res==b:
			res-=1
	ans.append(res)
	
for e in ans:
	print(e)