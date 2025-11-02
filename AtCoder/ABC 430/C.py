n, a, b = map(int, input().split())
s = list(input())
ct_a = [0 for _ in range(n + 1)]
ct_b = [0 for _ in range(n + 1)]

for i in range(1, n + 1):
	if s[i - 1] == 'a':
		ct_a[i] = ct_a[i - 1] + 1
		ct_b[i] = ct_b[i - 1]
	else:
		ct_a[i] = ct_a[i - 1]
		ct_b[i] = ct_b[i - 1] + 1

ans = 0
ra = rb = 0
for l in range(n):
	if ra < l + 1: ra = l + 1
	if rb < l + 1: rb = l + 1
	
	while ra <= n and ct_a[ra] - ct_a[l] < a:
		ra += 1
	while rb <= n and ct_b[rb] - ct_b[l] < b:
		rb += 1
	
	if ra <= n:
		left = max(ra, l + 1)
		right = min(rb - 1, n)
		if left <= right:
			ans += right - left + 1

print(ans)
