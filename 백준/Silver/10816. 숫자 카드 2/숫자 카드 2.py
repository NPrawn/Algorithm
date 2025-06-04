def left_idx(arr, t):
    st = 0
    en = len(arr)
    while st<en:
        mid = (st+en)//2
        if arr[mid] >= t: en = mid
        else: st = mid+1
    return st

def right_idx(arr, t):
    st = 0
    en = len(arr)
    while st<en:
        mid = (st+en)//2
        if arr[mid] > t: en = mid
        else: st = mid+1
    return st

n = int(input())
arr = list(map(int, input().split()))
input()
target = list(map(int, input().split()))
arr.sort()

for t in target:
    print(right_idx(arr,t) - left_idx(arr,t), end=' ')