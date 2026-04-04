def solution(progresses, speeds):
    ans = []
    arr = []
    for p, s in zip(progresses, speeds):
        remain = 100-p
        res = remain // s
        if remain % s != 0: res += 1
        arr.append(res)
    
    stk = []
    t = 0
    for e in arr:
        if (stk and t < e):
            ans.append(len(stk))
            stk.clear()
            t = 0
        stk.append(e)
        t = max(t, e)
    ans.append(len(stk))
    return ans