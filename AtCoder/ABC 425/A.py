n = int(input())

ans = 0
for i in range(1, n+1):
    num = i**3
    if i%2==1: num = -num
    ans+=num
print(ans)