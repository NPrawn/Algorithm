T = int(input())

for _ in range(T):
    n,m,x,y = map(int,input().split())
    a = list(map(int,input().split()))
    b = list(map(int,input().split()))
    ans = len(a) + len(b)
    print(ans)