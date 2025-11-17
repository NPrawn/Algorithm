import math

T = int(input())
ans = []
for _ in range(T):
	n, d, g = map(int, input().split())
	if (g==0 and d>0) or (g==100 and d<100):
		ans.append('Broken')
		continue
	else:
		if d!=0 and g!=100:
			dmin = 100 // math.gcd(d, 100)
			if dmin > n:
				ans.append('Broken')
				continue
	ans.append('Possible')

for i, e in enumerate(ans):
	print(f'#{i+1} {e}')