from collections import Counter

target = Counter(input())
n = int(input())
strings = []
ans = float('inf')

for _ in range(n):
	c, s = input().split()
	c = int(c)
	s = Counter(s)
	strings.append([c,s])

ans = float('inf')
for mask in range(1 << n):
	subset = [strings[i] for i in range(n) if (mask >> i) & 1]
	cost = 0
	counter = Counter()
	for c, s in subset:
		cost+=c
		counter+=s
	if target <= counter:
		ans = min(ans, cost)

print(ans if ans!=float('inf') else -1)