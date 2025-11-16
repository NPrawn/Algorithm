T = int(input())
ans = []
for _ in range(T):
	n = int(input())
	ans.append('Alice' if n%2==0 else 'Bob')

for i, e in enumerate(ans):
	print(f'#{i+1} {e}')