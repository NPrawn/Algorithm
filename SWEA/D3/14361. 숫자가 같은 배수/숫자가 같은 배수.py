from collections import Counter

T = int(input())
ans = []
for _ in range(T):
	num = int(input())
	arr = []
	for i in range(2, 11):
		arr.append(num*i)
	num = str(num)
	num = Counter(num)
	ok = False
	for a in arr:
		c = str(a)
		counter = Counter(c)
		if num==counter: ok=True
	
	ans.append('possible' if ok else 'impossible')

for i, e in enumerate(ans):
	print(f'#{i+1} {e}')