def solution(s):
    ans = 1
    n = len(s)

    for i in range(n):
        l = i
        r = i

        while 0 <= l and r < n and s[l] == s[r]:
            ans = max(ans, r - l + 1)
            l -= 1
            r += 1

        l = i
        r = i + 1

        while 0 <= l and r < n and s[l] == s[r]:
            ans = max(ans, r - l + 1)
            l -= 1
            r += 1

    return ans