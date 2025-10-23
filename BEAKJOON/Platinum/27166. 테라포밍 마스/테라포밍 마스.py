a,b,x,y,z = map(int,input().split())
t = 0

while z!=0:
    t+=1
    a+=b

    rem = (y*z-a)//b
    k = z-x-1

    tmp = z
    if a + b*(z-1) >= y*z and a>=y:
        a-=y
        z-=1
    elif a>=x+y and x<=rem and b<=y:
        a-=y
        z-=1
        a-=x
        b+=1
    elif a >= x and x<= rem:
        a-=x
        b+=1

print(t)