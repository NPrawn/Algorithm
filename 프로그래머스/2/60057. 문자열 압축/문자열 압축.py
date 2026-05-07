def solution(s):
    n = len(s)
    ans = float('inf')
    for i in range(1, n + 1):
        lst = []
        for j in range(0, n, i):
            lst.append(s[j:j+i])
        prev = lst[0]
        res = ""
        ct = 1
        for nxt in lst[1:]:
            if prev == nxt:
                ct+=1
                continue
            if ct != 1:
                res+= str(ct)
            res+= prev
            prev = nxt
            ct = 1
        if ct != 1:
            res+= str(ct)
        res+= prev
        ans = min(ans, len(res))
    return ans