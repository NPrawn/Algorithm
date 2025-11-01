n, k = map(int, input().split())
arr = list(map(int, input().split()))
prefix_sum = [0]
for a in arr:
	prefix_sum.append(prefix_sum[-1]+a)

ans = []
l, r = 0, k
while r<=n:
	ans.append(prefix_sum[r]-prefix_sum[l])
	l+=1
	r+=1

print(max(ans))