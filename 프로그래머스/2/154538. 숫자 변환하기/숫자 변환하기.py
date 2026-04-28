from collections import deque

def solution(x, y, n):
    dist = [-1 for _ in range(1000005)]
    q = deque()
    dist[x] = 0
    q.append(x)
    
    while q:
        now = q.popleft()
        nxt = now + n
        
        if nxt <= 1000000 and dist[nxt] == -1:
            dist[nxt] = dist[now] + 1
            q.append(nxt)
        
        nxt = now * 2
        if nxt <= 1000000 and dist[nxt] == -1:
            dist[nxt] = dist[now] + 1
            q.append(nxt)
            
        nxt = now * 3
        if nxt <= 1000000 and dist[nxt] == -1:
            dist[nxt] = dist[now] + 1
            q.append(nxt)
        
    answer = dist[y]
    return answer