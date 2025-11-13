from itertools import combinations

def solution(n, q, ans):
    answer = 0
    arr = list(range(1, n+1))
    n = len(arr)
    for subset in combinations(arr, 5):
        ok = True
        for lst, a in zip(q, ans):
            ct = 0
            for l in lst:
                if l in subset: ct+=1
            if ct!=a: ok = False
        if ok: answer+=1
    return answer