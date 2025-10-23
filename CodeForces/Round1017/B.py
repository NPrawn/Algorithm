T = int(input())

ans = []
for _ in range(T):
    n, m, l, r = map(int, input().split())
    for t in range(n-m):
        if (abs(l) >= abs(r)):
            l += 1
        else:
            r -= 1
    ans.append(f"{l} {r}")

for e in ans:
    print(e)