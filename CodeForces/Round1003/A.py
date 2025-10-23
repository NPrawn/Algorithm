n = int(input())

ans = []
for _ in range(n):
    arr = list(input())
    arr[-2] = 'i'
    ans.append(arr[:-1])

for e in ans:
    for item in e:
        print(item, end='')
    print()