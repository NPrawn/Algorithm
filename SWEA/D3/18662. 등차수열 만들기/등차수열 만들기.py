T = int(input())
ans = []
for _ in range(T):
	a, b, c = map(int, input().split())
	res = float('inf')
	k = b+b-a
	res = min(res, abs(c-k))
	k = b-(c-b)
	res = min(res, abs(a-k))
	k = (a+c)/2
	res = min(res, abs(b-k))
	ans.append(res)

for i, e in enumerate(ans):
	print(f'#{i+1} {e:.1f}')
	