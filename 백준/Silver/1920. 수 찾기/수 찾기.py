def binary_search(arr, t):
    st = 0
    en = len(arr)-1
    while st<=en:
        mid = (st+en)//2
        if arr[mid] < t:
            st = mid+1
        elif arr[mid] > t:
            en = mid-1
        else:
            return 1
        
    return 0

n = int(input())
arr = list(map(int, input().split()))
arr.sort()
input()
target = list(map(int, input().split()))

for t in target:
    print(binary_search(arr, t))