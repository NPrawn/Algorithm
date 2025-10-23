t = int(input())

for _ in range(t):
    arr = list(input())
    for i in range(len(arr)-1, -1, -1):
        if arr[i] == 'p': print('q', end='')
        elif arr[i] == 'q': print('p', end='')
        else: print('w', end='')
    print()