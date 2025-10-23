import sys

n, t = map(int, sys.stdin.readline().split())

arr = list(map(int, sys.stdin.readline().split()))

a = arr[:t]
b = arr[t:]
a.sort()

for e in a:
    print(e, end=" ")
for e in b:
    print(e, end=" ")