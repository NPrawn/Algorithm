T = int(input())



for _ in range(T):
    H, W = map(int, input().split())
    ALL = 1 << W
    board = []
    for _ in range(H):
        board.append(list(input()))
    dp = [[0 for _ in range(2**W)] for _ in range(H)]
    orig = []
    for row in board:
        mask = 0
        for j, c in enumerate(row):
            if c == '#':
                mask |= (1 << j)
        orig.append(mask)
    
    ok = [[True]*ALL for _ in range(ALL)]
    for a in range(ALL):
        for b in range(ALL):
            x = a & b
            ok[a][b] = not (x & (x<<1))
    
    states = []
    for m in orig:
        cur = []
        for s in range(ALL):
            if (s&~m) == 0:
                cost = (m & ~s).bit_count()
                cur.append((s, cost))
        states.append(cur)
    dp = {s: c for s, c in states[0]}
    for i in range(1, H):
        ndp = {}
        for s, c in states[i]:
            best = float('inf')
            for ps, pc in dp.items():
                if ok[ps][s]:
                    best = min(best, pc+c)
            if best < float('inf'):
                ndp[s] = best
        dp = ndp

    print(min(dp.values()))