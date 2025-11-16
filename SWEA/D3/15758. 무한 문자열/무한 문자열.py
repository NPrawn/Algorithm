T = int(input())
ans = []
for _ in range(T):
	A, B = input().split()
	a = A*len(B)
	b = B*len(A)
	ans.append('yes' if a==b else 'no')

for i,e in enumerate(ans):
	print(f'#{i+1} {e}')