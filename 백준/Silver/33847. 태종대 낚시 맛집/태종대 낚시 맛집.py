import sys

n = int(sys.stdin.readline())
c = int(sys.stdin.readline())
fishes = []
sum = 0
for _ in range(n):
    x, s, w = list(map(int, sys.stdin.readline().split()))
    fishes.append([x,s,w])
    sum += x

ans = 0
fishes.sort(key=lambda x: (-x[1], x[0]))

for T in range(sum+1):
    t = T
    res = 0
    vis = [False] * n

    while True:
        if t < 0 : break
        mx = 0
        price = 0
        idx = -1
        for i, fish in enumerate(fishes):
            if vis[i]:
                continue
            if fish[0] <= t and fish[1] > mx:
                mx = fish[1]
                idx = i
        if idx == -1: break
        t -= fishes[idx][0]
        res += fishes[idx][2]
        vis[idx] = True

    res = res - (T*c)
    ans = max(ans, res)

print(ans)
