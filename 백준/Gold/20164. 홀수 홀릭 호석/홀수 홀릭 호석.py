arr = list(map(int, input()))
maxans = -float('INF')
minans = float('INF')


def f(A, cnt):
    global maxans
    global minans
    ct = cnt
    for a in A:
        if a % 2 == 1: ct += 1
    # print(A, ct)
    if len(A) == 1:
        maxans = max(maxans, ct)
        minans = min(minans, ct)
    elif len(A) == 2:
        newA = list(map(int, str(A[0] + A[1])))
        f(newA, ct)
    else:
        for i in range(len(A)):
            for j in range(i + 2, len(A)):
                if j <= i: continue
                # a = str("".join(A[:i + 1]))
                a = str("".join(str(A[idx]) for idx in range(i+1)))
                b = str("".join(str(A[idx]) for idx in range(i+1, j)))
                c = str("".join(str(A[idx]) for idx in range(j, len(A))))
                res = int(a) + int(b) + int(c)
                newA = list(map(int, str(res)))
                f(newA, ct)


f(arr, 0)
print(minans, maxans)
