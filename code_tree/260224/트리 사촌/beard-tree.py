n, k = map(int, input().split())
arr = list(map(int, input().split()))
stk = []
p = [0 for _ in range(1000005)]
idx = 0
for a in arr[1:]:
    if not stk or stk[-1] == a-1:
        stk.append(a)
    else:
        while stk:
            e = stk.pop()
            p[e] = arr[idx]
        idx+=1
        stk.append(a)
while stk:
    e = stk.pop()
    p[e] = arr[idx]
idx+=1

parent = p[k]
gp = p[parent]
s = set()
ans = 0
for i, a in enumerate(p):
    if a==gp: s.add(i)
for i, a in enumerate(p):
    if a in s and p[i] != p[k]:
        ans += 1
if p[k]== 0 or p[p[k]] == 0: ans = 0
print(ans)