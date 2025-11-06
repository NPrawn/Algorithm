n = int(input())
arr = []
for _ in range(n):
	arr.append(int(input()))

total = sum(arr)
target = total//n
ans = 0
for a in arr:
	if a>=target: continue
	ans+=target-a

print(ans)