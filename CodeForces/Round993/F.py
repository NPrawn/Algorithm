import math

n, m, q = map(int,input().split())
a = list(map(int, input().split()))
b = list(map(int, input().split()))

row_sum = []
col_sum = []
sum_a = sum(a)
sum_b = sum(b)
total = sum_a * sum_b

arrA = [sum_a - ai for ai in a if abs(sum_a - ai) < 200001]
arrB = [sum_b - bi for bi in b if abs(sum_b - bi) < 200001]

apos = [0 for _ in range(400005)]
bpos = [0 for _ in range(400005)]
for A in arrA:
    apos[A] = 1

for B in arrB:
    bpos[B] = 1

ans = []
for _ in range(q):
    x = int(input())
    xx = abs(x)
    for i in range(1, xx+1):
        if i > math.sqrt(xx): break
        if xx%i != 0: continue
        j = xx//i
        if x>0 and apos[i] and bpos[j]: ans.append('YES'); break
        if x>0 and apos[j] and bpos[i]: ans.append('YES'); break
        if x>0 and apos[-i] and bpos[-j]: ans.append('YES'); break
        if x>0 and apos[-j] and bpos[-i]: ans.append('YES'); break
        if x<0 and apos[-i] and bpos[j]: ans.append('YES'); break
        if x<0 and apos[i] and bpos[-j]: ans.append('YES'); break
        if x<0 and apos[-j] and bpos[i]: ans.append('YES'); break
        if x<0 and apos[j] and bpos[-i]: ans.append('YES'); break
    if len(ans)==_: ans.append('NO')

for e in ans:
    print(e)