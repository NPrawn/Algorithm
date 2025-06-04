import bisect
n = int(input())
arr = list(map(int, input().split()))
input()
target = list(map(int, input().split()))
arr.sort()

for t in target:
    print(bisect.bisect_right(arr,t) - bisect.bisect_left(arr, t), end= ' ')