def solution(sticker):
    n = len(sticker)
    if n == 1:
        return sticker[0]
    if n == 2:
        return max(sticker[0], sticker[1])

    dp = [[0, 0] for _ in range(n - 1)]
    dp[0][0] = 0
    dp[0][1] = 0

    for i in range(1, n - 1):
        dp[i][0] = max(dp[i - 1][0], dp[i - 1][1])
        dp[i][1] = dp[i - 1][0] + sticker[i]

    dp1 = [[0, 0] for _ in range(n - 1)]
    dp1[0][0] = 0
    dp1[0][1] = sticker[0]
    dp1[1][0] = sticker[0]
    dp1[1][1] = -10**18

    for i in range(2, n - 1):
        dp1[i][0] = max(dp1[i - 1][0], dp1[i - 1][1])
        dp1[i][1] = dp1[i - 1][0] + sticker[i]

    answer = max(dp[-1][0] + sticker[-1], dp[-1][0], dp[-1][1], dp1[-1][0], dp1[-1][1])
    return answer