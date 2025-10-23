N = int(input())
ans = 0

k = N//4

board = [
    ['aaab'],
    ['dabb'],
    ['ddcb'],
    ['dccc']]

if N%4!=0: print(-1)
else:
    for i in range(k):
        for row in board:
            for i in range(k):
                print(*row, end='')
            print()
