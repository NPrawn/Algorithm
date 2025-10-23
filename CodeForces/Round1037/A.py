t = int(input())

for _ in range(t):
    x = int(input())
    tmp = x
    ans = float("inf")
    while True:
        if tmp < 10:
            ans = min(tmp, ans)
            break
        ans = min(tmp%10, ans)
        tmp = tmp // 10

    print(ans)