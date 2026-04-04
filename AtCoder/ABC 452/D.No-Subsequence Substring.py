S = input()
T = input()

n = len(S)
m = len(T)

dp = [-1] * m
ans = 0

for r, c in enumerate(S):
    for j in range(m - 1, 0, -1):
        if c == T[j] and dp[j - 1] != -1:
            dp[j] = max(dp[j], dp[j - 1])

    if c == T[0]:
        dp[0] = r

    if dp[m - 1] == -1:
        ans += r + 1
    else:
        ans += r - dp[m - 1]

print(ans)