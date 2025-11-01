n = int(input())
arr = list(map(int, input().split()))
up = [0 for _ in range(n)]
up[0] = 1
down = [0 for _ in range(n)]
down[0] = 1
for i in range(1, n):
	if arr[i-1]<=arr[i]:
		up[i] = up[i - 1] + 1
	else:
		up[i] = 1
	if arr[i-1]>=arr[i]:
		down[i] = down[i-1]+1
	else:
		down[i] = 1

print(max(max(up), max(down)))