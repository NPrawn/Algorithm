from collections import deque

def solution(players, m, k):
    answer = 0
    base = m
    lst = [0 for _ in range(50)]
    for i, p in enumerate(players):
        now = base+lst[i]
        ct = 0
        while p>=now:
            answer+=1
            now+=m
            ct += m
        for j in range(i, i+k):
            lst[j]+=ct
    return answer