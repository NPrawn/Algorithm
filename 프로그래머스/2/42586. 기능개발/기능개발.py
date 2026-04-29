import math

def solution(progresses, speeds):
    answer = []
    arr = []
    for a, b in zip(progresses, speeds):
        k = 100 - a
        arr.append(math.ceil(k / b))
    stk = []
    mx = 0
    for a in arr:
        if not stk:
            mx = a
            stk.append(a)
        elif stk and a <= mx:
            stk.append(a)
        else:
            answer.append(len(stk))
            stk = [a]
            mx = a

    if len(stk) > 0:
        answer.append(len(stk))
    return answer