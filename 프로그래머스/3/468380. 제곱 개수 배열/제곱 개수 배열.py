from bisect import bisect_left

def solution(arr, l, r):
    n = len(arr)

    T = [0] * (n + 1)   # 길이 누적합
    Q = [0] * (n + 1)   # 제곱합 누적합

    for i in range(1, n + 1):
        T[i] = T[i - 1] + arr[i - 1]
        Q[i] = Q[i - 1] + arr[i - 1] * arr[i - 1]

    def pref(pos):
        if pos <= 0:
            return 0
        i = bisect_left(T, pos, 1, n + 1)
        return Q[i - 1] + (pos - T[i - 1]) * arr[i - 1]

    w = r - l + 1
    K = pref(r) - pref(l - 1)

    max_start = T[n] - w + 1
    s = 1
    i = 1
    j = 1
    C = 0

    while s <= max_start:
        while T[i] < s:
            i += 1

        e = s + w - 1
        while T[j] < e:
            j += 1

        sR = min(T[i], T[j] - w + 1, max_start)

        ai = arr[i - 1]
        aj = arr[j - 1]

        if i == j:
            v0 = w * ai
        else:
            left_cnt = T[i] - s + 1
            right_cnt = e - T[j - 1]
            mid_sum = Q[j - 1] - Q[i]
            v0 = left_cnt * ai + mid_sum + right_cnt * aj

        d = aj - ai
        cnt = sR - s + 1

        if d == 0:
            if v0 == K:
                C += cnt
        else:
            diff = K - v0
            if diff % d == 0:
                t = diff // d
                if 0 <= t < cnt:
                    C += 1

        s = sR + 1

    return [K, C]