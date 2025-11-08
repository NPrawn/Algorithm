n, m, k = map(int, input().split())
heads = list(map(int, input().split()))
bodies = list(map(int, input().split()))

heads.sort()
bodies.sort()
ans = 0
cur = 0
for h in heads:
	while cur<m and bodies[cur]<h:
		cur+=1
	if cur==m: break
	ans+=1
	cur+=1

print('Yes' if ans>=k else 'No')