T = int(input())
ans = []
for _ in range(T):
	a, b, n = map(int,input().split())
	if b<a: a, b = b, a
	ct = 0
	while a<=n and b<=n:
		ct+=1
		a+=b
		if a>n: break
		ct+=1
		b+=a
	ans.append(ct)

for e in ans:
	print(e)