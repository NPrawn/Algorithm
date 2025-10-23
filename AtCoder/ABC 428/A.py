s, a, b, x = map(int, input().split())

ans = 0
t = 0
while True:
    if t>=x:break
    for _ in range(a):
        ans+=s
        t+=1
        if t>=x: break
    if t>=x: break
    t+=b

print(ans)