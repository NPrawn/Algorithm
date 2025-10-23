T = int(input())
ans = []

for _ in range(T):
    a, b = map(int, input().split())
    x = a ^ b
    if x <= a: ans.append([x])
    elif a==b: ans.append([])
    elif a.bit_length() < b.bit_length(): ans.append([-1])
    else:
        k = a.bit_length()
        m = (1 << k) - 1
        x1 = m^a
        x2 = m^b
        ans.append([x1,x2])

for e in ans:
    if len(e)==0:
        print(0)
    elif e[0]==-1:
        print(-1)
    else:
        print(len(e))
        print(*e)
