inf = float('inf')
n = int(input())
tree = [0] + list(map(int, input().split()))

arr = []
dep = []


def inorder(node, d):
	if node > n:
		return
	inorder(node * 2, d + 1)
	arr.append(tree[node])
	dep.append(d)
	inorder(node * 2 + 1, d + 1)


inorder(1, 0)

h = max(dep)
pos = [[] for _ in range(h + 1)]

for i in range(n):
	pos[dep[i]].append((i, arr[i]))

ans = -inf

for s in range(h + 1):
	tmp = [-inf] * n
	
	for e in range(s, h + 1):
		for idx, val in pos[e]:
			tmp[idx] = val
		
		cur = tmp[0]
		mx = tmp[0]
		for i in range(1, n):
			if tmp[i] == -inf: continue
			cur = max(tmp[i], cur + tmp[i])
			mx = max(mx, cur)
		
		ans = max(ans, mx)

print(ans)
