import bisect

n, m = map(int, input().split())

board = [[] for _ in range(n)]
for i in range(n):
    tmp = list(map(int, input().split()))
    lst = sorted(tmp)
    t=[]
    t.append(lst[0])
    for item in lst[1:]:
        if item != t[-1]: t.append(item)
    for item in tmp:
        board[i].append(bisect.bisect_left(t, item))

ct = 0
for i in range(n):
    for j in range(i+1,n):
        if board[i]==board[j]: ct+=1

print(ct)