for num in range(10, 100):
    a = num//10
    b = num%10
    if (a+b)%6!=0: continue
    if a==8 or b==8: continue
    n = b*10 + a
    if n%4!=0: continue
    print(num)
    break
