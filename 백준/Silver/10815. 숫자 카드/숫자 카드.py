n = int(input())
set = set(map(int, input().split()))
m = int(input())
for a in map(int, input().split()):
    if a in set: print('1', end=' ')
    else: print('0', end=' ')