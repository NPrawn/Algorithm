from collections import Counter

def solution(points, routes):
    answer = 0
    points = [[0,0]] + points
    routes = [[0]] + routes
    time = [[] for _ in range(1000000)]
    for route in routes:
        x, y = points[route[0]]
        t = 1
        time[0].append((x,y))
        for r in route[1:]:
            nx, ny = points[r]
            if nx<x:
                for i in range(x-1, nx-1, -1):
                    time[t].append((i,y))
                    t+=1
            elif nx>x:
                for i in range(x+1,nx+1):
                    time[t].append((i,y))
                    t+=1
            if ny<y:
                for i in range(y-1, ny-1, -1):
                    time[t].append((nx,i))
                    t+=1
            elif ny>y:
                for i in range(y+1,ny+1):
                    time[t].append((nx,i))
                    t+=1
            x,y = nx, ny
                
    for a in time:
        if not a: break
        counter = Counter(a)
        for c in counter:
            if counter[c] >= 2: answer+=1
    return answer