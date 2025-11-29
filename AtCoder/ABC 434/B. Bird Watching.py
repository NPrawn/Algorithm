n, m = map(int, input().split())
birds = [[] for _ in range(m+1)]
for _ in range(n):
	a, b = map(int, input().split())
	birds[a].append(b)

for bird in birds[1:]:
	print(sum(bird)/len(bird))