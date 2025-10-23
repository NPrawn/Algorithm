from collections import deque

N = int(input())
q = deque(list(range(1,N)))
ans = []

while len(q) > 1:
    a = q.pop()
    b = q.pop()
    if a>b: a, b = b, a
    ans.append((a, b))
    q.appendleft(b-a)

n = q.pop()
ans.append((N, n))
print(N-n)
for row in ans:
    print(*row)