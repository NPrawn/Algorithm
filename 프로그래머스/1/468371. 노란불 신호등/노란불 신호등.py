def solution(signals):
    answer = 0
    n = len(signals)
    MAX = 2000000
    yellow = [0 for _ in range(2000000)]
    for g, y, r in signals:
        t = 1
        while t < 2000000:
            t+=g
            if t+y >= 2000000: break
            for i in range(t, t + y):
                yellow[i] += 1
            t+=y
            t+=r
        
    
    for i, e in enumerate(yellow):
        if e==n:
            answer = i
            break
    else:
        answer = -1
    return answer