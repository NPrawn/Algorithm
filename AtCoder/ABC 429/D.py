from collections import defaultdict

n, m, c = map(int, input().split())
arr = list(map(int, input().split()))

s = defaultdict(lambda: 0)
for a in arr:
    s[a] += 1

lst = []
for num in s:
    lst.append([num, s[num]])
lst.sort()

le = len(lst)
ans = 0
res = []
if le==1:
    ans+= c + (lst[0][1] - c%lst[0][1])
else:
    for l in range(le):
        r = l+1
        r%=le
        ct = lst[l][1]
        while ct < c:
            ct += lst[r][1]
            r+=1
            r%=le
        res.append([lst[l][0], ct])

for a,b in res:
    ans+=b
print(ans)