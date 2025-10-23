T = int(input())
ans = []
stk = []
bal = 0
mn = 0
length = 0
state = [[0] * 2 for _ in range(T+1)]

for t in range(1, T+1):
    cmd = list(input().split())
    if cmd[0]=='1':
        stk.append(cmd[1])
        if cmd[1]=='(': bal+=1
        else: bal-=1
        mn = min(mn, bal)
        length+=1
        state[length] = [bal, mn]
    else:
        stk.pop()
        length-=1

    bal, mn = state[length]
    if bal==0 and mn>=0: ans.append('Yes')
    else: ans.append('No')
    past = cmd[0]

for e in ans:
    print(e)