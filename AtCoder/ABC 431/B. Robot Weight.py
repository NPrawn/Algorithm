X = int(input())
n = int(input())
parts = [0] + list(map(int, input().split()))
q = int(input())
ans = []

for _ in range(q):
	p = int(input())
	X += parts[p]
	parts[p] = -parts[p]
	ans.append(X)

for e in ans:
	print(e)