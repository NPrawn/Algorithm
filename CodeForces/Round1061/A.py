T = int(input())
ans = []
for _ in range(T):
    n = int(input())
    ct = 0
    while n > 2:
        tmp = n//3
        ct += tmp
        n -= tmp
        n -= tmp
    ans.append(ct)

for e in ans:
    print(e)