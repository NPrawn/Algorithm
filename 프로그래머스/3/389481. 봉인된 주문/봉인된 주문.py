def solution(n, bans):
    answer = ''
    lst = []
    for b in bans:
        k = 0
        for c in b:
            k+=ord(c)-ord('a')+1
            k*=26
        lst.append(k//26)
    lst.sort()
    for num in lst:
        if num<=n: n+=1
    
    ans= []
    while n!=0:
        ans.append(n%26)
        k = 0
        if n%26==0: k=-1
        n //= 26
        n+=k
    
    for a in ans:
        if a == 0: a=26
        answer = chr(a+96) + answer

    return answer