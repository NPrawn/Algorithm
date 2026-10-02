from collections import defaultdict
import math

def solution(fees, records):
    answer = defaultdict(lambda: 0)
    inTime = defaultdict(lambda: 0)
    sumTime = defaultdict(lambda: 0)
    cars = []

    for record in records:
        hm, number, tp = record.split()
        h, m = hm.split(':')
        m = int(m) + int(h) * 60
        if tp == 'IN':
            inTime[number] = m
        else:
            m -= inTime[number]
            del inTime[number]
            sumTime[number] += m
    
    for key, value in inTime.items():
        m = 23*60 + 59
        sumTime[key] += (m - value)
    
    for key, value in sumTime.items():
        cars.append(key)
        if value <= fees[0]:
            answer[key] = fees[1]
        else:
            answer[key] = fees[1] + (math.ceil((value - fees[0]) / fees[2]) * fees[3])
    ans = []
    cars.sort()
    for car in cars:
        ans.append(answer[car])
    
    return ans