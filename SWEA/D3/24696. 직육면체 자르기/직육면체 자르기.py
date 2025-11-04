T = int(input())
ans = []
for _ in range(T):
	a, b, c = map(int, input().split())
	res = a*b*c
	ans.append(1 if res%2==0 else 2)
	
for e in ans:
	print(e)