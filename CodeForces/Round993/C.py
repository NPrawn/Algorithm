T = int(input())
for _ in range(T):
    m, row1, row2, c = map(int,input().split())
    if row1>m: row1=m
    if row2>m: row2=m
    rem = m-row1
    rem += m-row2
    row3 = c
    if row3>rem: row3=rem
    print(row1+row2+row3)