n, k = map(int ,input().split())
arr = map(int, input().split())
s = [0]
for a in arr:
	s.append(s[-1] + a)

ans = 0
for l in range(1, len(s)):
	for r in range(l, len(s)):
		if s[r]-s[l-1] == k:
			ans+=1

print(ans)