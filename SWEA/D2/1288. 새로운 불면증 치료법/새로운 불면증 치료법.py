T = int(input())
for tc in range(1, T+1):
	n = int(input())
	ans = n
	arr = list(str(n))
	s = set(arr)
	while len(s) < 10:
		ans += n
		arr = list(str(ans))
		for a in arr:
			s.add(a)
	
	print(f"#{tc} {ans}")