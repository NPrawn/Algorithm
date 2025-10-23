N = int(input())

n = (1<<N)-1
index = [0] * (n+1)
cnt = 0

stk = [(1,False)]
p, y = 0, 0

while stk:
    i, vis = stk.pop()
    if i > n: continue
    if vis:
        if i != 1:
            cnt+=1
            if i % 2 == 1:
                if cnt%2==1: p+=1
                else: y+=1

    else:
        stk.append((i,True))
        r = 2*i+1
        if r<=n:
            stk.append((r,False))
        l = 2*i
        if l<=n:
            stk.append((l,False))

if p>y:
    print('Pink Bean')
elif p<y:
    print('Yeti')
else:
    print('Draw')