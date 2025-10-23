T = int(input())
ans = []
for _ in range(T):
    n = int(input())
    arr = list(map(int, input()))
    res = []
    for idx, val in enumerate(arr):
        if val==0:
            res.append(idx+1)
    ans.append(res)

for lst in ans:
    print(len(lst))
    print(*lst)