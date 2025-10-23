n = int(input())
ans = []

n+=1
while n>1:
    ans.append(7 if (n&1) else 4)
    n>>=1

for e in ans[::-1]:
    print(e, end='')