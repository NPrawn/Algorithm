while True:
    cmd = list(map(int, input().split()))
    if cmd[0] == 0: break
    a, b = cmd
    ans = []
    if b%2==0:
        ans.append(b-1)
        ans.append(a-b+1)
        ans.append(a-b+2)
    else:
        ans.append(b+1)
        ans.append(a-b)
        ans.append(a-b+1)
    ans.sort()
    print(*ans)
