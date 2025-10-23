T = int(input())
ans = []
for _ in range(T):
    n = int(input())
    s = list(map(int,input()))
    if 0 in s and 1 not in s: ans.append(0); continue
    if 1 in s and 0 not in s: ans.append(0); continue
    res = float('inf')
    for target in range(2):
        ct = 0
        diff = 0
        for i in range(n//2):
            if s[i]==target: diff+=1
            elif s[i]!=target: ct+=i+1; ct+=diff*2
        diff=0
        for i in range(n-1, n//2, -1):
            if s[i]==target: diff+=1
            elif s[i]!=target: ct+=n-i-1; ct+=diff*2
        res = min(res, ct)
    ans.append(res)

for e in ans:
    print(e)