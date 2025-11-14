def solution(schedules, timelogs, startday):
    answer = 0
    sat = 6-startday
    sun = sat+1
    if sat<0: sat=6; sun=0
    for schedule, timelog in zip(schedules, timelogs):
        deadline = schedule+10
        if schedule % 100 >= 50:
            deadline = schedule+50
        ok = True
        print(sat, sun, schedule, deadline,timelog)
        for i, time in enumerate(timelog):
            if i==sat or i==sun: continue
            if not time<=deadline: ok = False
        
        if ok: answer+=1
        
        
    return answer