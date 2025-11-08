T = int(input())
ans = []
for _ in range(T):
	n = int(input())
	arr = list(map(int, input().split()))
	inf = float('inf')
	mn = inf
	mx = -inf
	for a in arr:
		mn = min(mn, a)
		mx = max(mx, a)
	
	x = int(input())
	ans.append('YES' if mn<=x<=mx else 'NO')

for e in ans:
	print(e)