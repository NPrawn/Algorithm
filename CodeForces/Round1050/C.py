T = int(input())

for _ in range(T):
    n, m = map(int, input().split())
    command = []
    for i in range(n):
        command.append(list(map(int,input().split())))
    cur = 0
    ans = 0
    t = 0
    for cmd in command:
        req = abs(cmd[1] - cur)
        time = cmd[0] - t
        if req==1 and time%2==1: ans+=time
        if req==1 and time%2==0: ans+=time-1
        if req==0 and time%2==0: ans+=time
        if req==0 and time%2==1: ans+=time-1
        t, cur = cmd
    ans += m-t
    print(ans)