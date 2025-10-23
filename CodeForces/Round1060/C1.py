import math

T = int(input())
ans = []
for _ in range(T):
    n = int(input())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    s = set()
    factors = [set() for _ in range(n)]
    check = False
    for idx, num in enumerate(a):
        if num in s:
            check = True
            break
        if num != 1: s.add(num)
        factors[idx].add(num)
        for i in range(2, math.floor(num**0.5)+2):
            if i**2 > num: break
            if num%i==0:
                j = num//i
                if j in s or i in s:
                    check = True
                    break
                s.add(i)
                s.add(j)
                factors[idx].add(i)
                factors[idx].add(j)
        if check: break

    if check:
        ans.append(0)
        continue
    

    for idx, num in enumerate(a):
        num+=1
        if num in s and num not in factors[idx]:
            check = True
            break
        for i in range(2, math.floor(num**0.5)+2):
            if i**2 > num: break
            if num%i==0:
                j = num//i
                if (j in s and j not in factors[idx]) or (i in s and i not in factors[idx]):
                    check = True
                    break
        if check: break
    if check:
        ans.append(1)
    else:
        ans.append(2)

for e in ans:
    print(e)