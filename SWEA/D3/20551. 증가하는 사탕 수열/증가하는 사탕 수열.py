T = int(input())
ans = []
for _ in range(T):
	a, b, c = map(int, input().split())
	ct = 0
	if b>=c:
		t = c-1
		ct += b-t
		b=t
	if a>=b:
		t = b-1
		ct += a-t
		a=t
	if a<=0 or b<=0 or c<=0: ans.append(-1)
	else: ans.append(ct)

for i, e in enumerate(ans):
	print(f'#{i+1} {e}')