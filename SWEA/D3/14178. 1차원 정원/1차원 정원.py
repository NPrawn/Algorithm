import math

T = int(input())
ans = []
for _ in range(T):
	n, d = map(int, input().split())
	k = d*2 + 1
	ans.append(math.ceil(n/k))

for i, e in enumerate(ans):
	print(f'#{i+1} {e}')