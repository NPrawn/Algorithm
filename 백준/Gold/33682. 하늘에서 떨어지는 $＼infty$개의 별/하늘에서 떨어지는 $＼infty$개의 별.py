import math

s,x,m,d,k = map(int, input().split())
g = math.gcd(x,m)

s %= g
t = 0

t = (m - 1 - s) // g * g + s

if t==0 or k//t==0:
    print(0)
else:
    print((d-1)//(k//t))