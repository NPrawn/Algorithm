T = int(input())

for _ in range(T):
    a, b = map(int,input().split())
    if b%2 == 0: print(0)
    else: print(a)
