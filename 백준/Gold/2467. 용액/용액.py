import bisect

n = int(input())
arr = list(map(int, input().split()))
arr.sort()
ans = []
k = float('inf')

for a in arr:
	a = -a
	st, en = -1, n-1
	while st<en:
		mid = (st+en+1)//2
		if arr[mid]>=a: en = mid-1
		else: st=mid
	l = st+1
	lst = []
	if 0<l<n-1:
		lst.append([abs(arr[l]-a), arr[l], -a])
	if 0<l:
		lst.append([abs(arr[l-1]-a), arr[l-1], -a])
	if l<n-1:
		lst.append([abs(arr[l+1]-a), arr[l+1], -a])
	for e,q,w in lst:
		if q==w: continue
		if e<k:
			ans = [q,w]
			k = e
ans.sort()
print(*ans)