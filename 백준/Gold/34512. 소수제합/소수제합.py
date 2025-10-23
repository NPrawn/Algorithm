from itertools import combinations_with_replacement
N = int(input())

def solve():
    for i in range(1, N):
        if (N-i*3)%2==0:
            a = i
            b = (N-3*a)//2
            arr = [2]*(a*3) + [3]*(b*2)
            return arr
    return [-1]

prime = []
for i in range(2,150):
    b=True
    for j in range(2, i):
        if i%j==0: b=False; break
    if b: prime.append(i)

def is_can(arr):
    if all(arr[0]==i for i in arr): return False
    s = sum(x**2 for x in arr)
    for e in arr:
        if s%e!=0: return False
    
    return True

ans = [-1]
if N<7:
    for comb in combinations_with_replacement(prime, N):
        if is_can(comb): ans = comb; break
else:
    ans = solve()

for e in ans:
    print(e, end=' ')