def solution(diffs, times, limit):
    lo, hi = 1, 10**15
    
    def can(level):
        time_prev = 0
        t = 0
        for diff, time in zip(diffs,times):
            k = max(0, diff-level)
            t += (time + time_prev) * k
            t+=time
            time_prev=time
            if t>limit: return False
        if t<=limit: return True
        else: return False
        
    while lo<hi:
        mid = (lo+hi)//2
        if can(mid):
            hi = mid
        else:
            lo = mid+1
    return lo