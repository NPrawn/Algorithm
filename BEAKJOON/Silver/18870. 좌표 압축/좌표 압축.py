import bisect
n = int(input())
arr = list(map(int,input().split()))
lst = sorted(arr)
l = []
l.append(lst[0])
for i in lst[1:]:
    if l[-1] != i: l.append(i)
for x in arr:
    print(bisect.bisect_left(l, x))