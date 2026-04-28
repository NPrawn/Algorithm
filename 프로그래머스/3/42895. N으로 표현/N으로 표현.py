from collections import defaultdict

def solution(N, number):
    n = N
    answer = 0
    candi = [set() for _ in range(9)]
    dt = defaultdict(lambda : 0)
    k = n
    for i in range(1, 9):
        candi[i].add(k)
        dt[k] = i
        k*=10
        k+=n
    
    for i in range(2, 9):
        for a in range(1, i+1):
            b = i - a
            for z in candi[a]:
                for x in candi[b]:
                    if dt[z+x] == 0:
                        candi[i].add(z+x)
                        dt[z+x] = i
                        
                    if dt[z-x] == 0:
                        candi[i].add(z-x)
                        dt[z-x] = i
                        
                    if dt[z*x] == 0:
                        candi[i].add(z*x)
                        dt[z*x] = i
                        
                    if x != 0 and dt[z//x] == 0:
                        candi[i].add(z//x)
                        dt[z//x] = i
                        
                    if dt[x-z] == 0:
                        candi[i].add(x-z)
                        dt[x-z] = i
                        
                    if z != 0 and dt[x//z] == 0:
                        candi[i].add(x//z)
                        dt[x//z] = i
                
                if dt[number] != 0: break
            if dt[number] != 0: break
        if dt[number] != 0: break
    
    return -1 if dt[number] == 0 else dt[number]