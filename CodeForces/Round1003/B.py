n = int(input())

ans = []
for _ in range(n):
    s = list(input())
    for i in range(len(s)-1):
        if s[i]==s[i+1]:
            ans.append(1)
            break
    if len(ans) == _: ans.append(len(s))

for e in ans:
    print(e)