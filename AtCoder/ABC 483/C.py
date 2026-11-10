n, m = map(int, input().split())
cnt = [0 for _ in range(n+1)]
adj = [[] for _ in range(n+1)]

for _ in range(m):
    a, b = map(int, input().split())
    cnt[a] += 1
    adj[a].append(b)

first, second = 0, 0

for i in range(1, n+1):
    if first == 0 or cnt[i] > cnt[first]:
        second = first
        first = i
    elif second == 0 or cnt[i] > cnt[second]:
        second = i

for k in range(1, n+1):
    winner = second if k == first else first
    score = cnt[winner]

    d = {}
    for b in adj[k]:
        d[b] = d.get(b, 0) + 1

    for b, v in d.items():
        total = cnt[b] + v

        if total > score or (total == score and b < winner):
            winner = b
            score = total

    print(winner)