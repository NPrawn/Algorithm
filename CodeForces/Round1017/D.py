from collections import deque

T = int(input())
ans = []

for _ in range(T):
    p = deque(input())
    s = deque(input())
    while len(p) > 0:
        now = p.popleft()
        ct1 = 1
        while True:
            if  len(p) > 0 and p[0] == now:
                ct1+=1
                p.popleft()
            else: break
        ct2 = 0
        while True:
            if len(s) > 0 and s[0] == now :
                ct2+=1
                s.popleft()
            else: break
        
        if not(ct1 <= ct2 <= ct1*2):
            ans.append("NO")
            break
    if len(p)==0 and len(s)>0 and len(ans) != _+1:
        ans.append("NO")
    elif len(ans) != _+1:
        ans.append("YES")

for e in ans:
    print(e)