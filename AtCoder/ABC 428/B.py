n, k = map(int, input().split())
s = list(input())
ans = []
d = {}
mx = 0
for i in range(n-k+1):
    t = ''.join(s[i:i+k])
    ct = 0
    for j in range(n-k+1):
        if t == ''.join(s[j:j+k]): ct+=1
    d[t] = ct


for e in d:
    mx = max(mx, d[e])

for e in d:
    if d[e]==mx:
        ans.append(e)

ans.sort()
print(mx)
print(*ans)