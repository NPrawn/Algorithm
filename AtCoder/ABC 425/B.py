import sys

n = int(input())
s = set(range(1,n+1))
p = [0 for _ in range(n)]
a = list(map(int, input().split()))

for i in range(n):
    if a[i] == -1: continue
    if a[i] not in s:
        print('No')
        sys.exit(0)
    p[i] = a[i]
    s.remove(a[i])

for i in range(n):
    if p[i] != 0: continue
    p[i] = s.pop()

print('Yes')
print(*p)