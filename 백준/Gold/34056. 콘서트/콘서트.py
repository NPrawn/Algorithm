n = int(input())
arr = [0]
arr.extend(list(map(int,input().split())))
q = int(input())

ans = []
for _ in range(q):
    cmd = list(map(int,input().split()))
    if cmd[0] == 1:
        c, x = cmd[1], cmd[2]
        for i in range(c+1, n+1):
            m = min(arr[i],x)
            arr[i] += m
            x-=m
            if x==0: break
        c, x = cmd[1], cmd[2]
        for i in range(c, 0, -1):
            m = min(arr[i],x)
            arr[i] += m
            x-=m
            if x==0: break
    if cmd[0] == 2:
        ans.append(arr[cmd[1]])

for e in ans:
    print(e)
