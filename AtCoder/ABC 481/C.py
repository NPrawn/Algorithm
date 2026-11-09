q = int(input())
idx = 1
dt = {}

for _ in range(q):
    s = input()
    res = dt.get(s, -1)
    if res == -1:
        dt[s] = idx
        res = idx
        idx += 1

    print(res)