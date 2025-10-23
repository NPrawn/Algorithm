import sys
from collections import deque

n = int(input())
board = [[float('inf') for _ in range(2)] for _ in range(n+1)]

if n==0:
    print('0 0')
    sys.exit(0)
board[1][0] = 1
board[1][1] = 1
dq = deque()
dq.append(1)
while dq:
    cur = dq.popleft()
    for i in range(3):
        if i==0:
            tom = cur+1
            water = board[cur][1]+1
        elif i==1:
            tom = cur*3
            water = board[cur][1]+3
        else:
            tom = cur*cur
            water = board[cur][1]+5
        if tom>n: continue

        if board[tom][0] >= board[cur][0]+1:
            board[tom][0] = board[cur][0]+1
            board[tom][1] = min(board[tom][1], water)
            dq.append(tom)

print(*board[-1])