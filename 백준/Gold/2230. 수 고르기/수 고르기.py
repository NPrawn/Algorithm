n, m = map(int,input().split())

arr=[]
for i in range(n):
    arr.append(int(input()))
arr.sort()

st = 0
en = 0
res = float('inf')
while en!=n and st!=n:
    t = arr[en] - arr[st]
    if t >= m:
        res = min(res,t)
        st+=1
    else: en+=1

print(res)