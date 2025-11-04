import math

T = int(input())
ans = []

def lcm(a, b):
	return a // math.gcd(a, b) * b

def representable(x, T):
	cur = 1
	for t in T:
		if x % t ==0:
			cur = lcm(cur, t)
			if cur == x:
				return True
	return cur==x
	
for _ in range(T):
	na, nb = map(int, input().split())
	A = list(map(int, input().split()))
	B = list(map(int, input().split()))
	
	ok = True
	for a in A:
		if not representable(a, B):
			ok = False
			break
	if ok:
		for b in B:
			if not representable(b, A):
				ok = False
				break
	ans.append('=' if ok else '!')

for e in ans:
	print(e)