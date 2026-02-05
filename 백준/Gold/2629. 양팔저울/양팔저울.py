from collections import deque

n = int(input())
arr = list(map(int, input().split()))
m = int(input())
items = list(map(int, input().split()))

dp = [0 for _ in range(50000)]
dp[0] = 1
q = deque()
q.append(0)
for a in arr:
    length = len(q)
    for _ in range(length):
        now = q.popleft()
        q.append(now)
        if dp[now+a] == 0:
            dp[now+a] = 1
            q.append(now+a)
        if dp[abs(now-a)] == 0:
            dp[abs(now-a)] = 1
            q.append(abs(now-a))

for a in items:
    print('Y' if dp[a] else 'N', end=' ')
