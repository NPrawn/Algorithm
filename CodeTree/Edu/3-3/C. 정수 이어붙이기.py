n, k = map(int, input().split())
arr = []
vis = [0 for _ in range(n)]
s = set()
for _ in range(n):
	a = input()
	arr.append(a)
	
def permutations(idx, new_arr):
	if idx==k:
		s.add(new_arr)
		return
	for i in range(len(arr)):
		if vis[i]: continue
		vis[i] = 1
		permutations(idx+1, new_arr + arr[i])
		vis[i] = 0

permutations(0, '')
print(len(s))