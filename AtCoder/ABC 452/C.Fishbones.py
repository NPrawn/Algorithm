n = int(input())
A, B = [], []
for _ in range(n):
	a, b = map(int, input().split())
	A.append(a)
	B.append(b)

m = int(input())
S = []
for _ in range(m):
	S.append(input())

check = [[[False for _ in range(27)] for _ in range(11)] for _ in range(11)]
for s in S:
	for i, c in enumerate(s, start=1):
		check[len(s)][i][ord(c) - 97] = True

ans = []
for s in S:
	if len(s) != n:
		ans.append('No')
		continue
	for i, c in enumerate(s):
		if not check[A[i]][B[i]][ord(c) - 97]:
			ans.append('No')
			break
	else:
		ans.append('Yes')

print('\n'.join(ans))