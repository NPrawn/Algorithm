n = int(input())
stk = []
ans = 0
for _ in range(n):
	a, b = map(int, input().split())
	while stk and stk[-1] > b: stk.pop()
	if stk and stk[-1] == b: continue
	if b>0:
		stk.append(b)
		ans+=1

print(ans)