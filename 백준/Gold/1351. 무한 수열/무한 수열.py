from collections import defaultdict

n, p, q = map(int, input().split())
A = defaultdict(lambda: 0)
ct = 0
def f(k):
	global ct
	if k==0: return 1
	if A[k] != 0: return A[k]
	ct += 1
	A[k] = f(k//p) + f(k//q)
	return A[k]

print(f(n))