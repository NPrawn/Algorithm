import bisect

n = int(input())
a = []
for i in range(n):
    a.append(int(input()))

two = []
for i in range(n):
    for j in range(n):
        two.append(a[i] + a[j])
two.sort()
mx = 0
for i in range(n):
    for j in range(n):
        target = a[j] - a[i]
        if bisect.bisect_right(two, target) - bisect.bisect_left(two, target) > 0:
            mx = max(mx, a[j])
print(mx)