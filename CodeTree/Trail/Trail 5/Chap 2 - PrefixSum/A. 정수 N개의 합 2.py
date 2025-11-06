n, k = map(int, input().split())
arr = list(map(int, input().split()))

ans = -float('inf')
psum = [0]
for a in arr:
	psum.append(psum[-1] + a)

l, r = 0, k-1
while r<n:
	ans = max(ans, psum[r+1] - psum[l])
	l+=1
	r+=1

print(ans)