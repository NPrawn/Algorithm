import sys
input = lambda: sys.stdin.readline().strip()

T = int(input())
ans = []
for _ in range(T):
    n, k = map(int, input().split())
    arr = list(map(int, input().split()))
    total = [0 for _ in range(max(arr)+5)]
    for e in arr: total[e]+=1
    for x, cnt in enumerate(total):
        if cnt % k == 0:
            total[x] //= k
        else:
            print(0)
            break
    else:
        freq = [0 for _ in range(max(arr)+5)]
        ct = 0
        l = 0
        for r, x in enumerate(arr):
            freq[x] += 1
            while freq[x] > total[x] and l <= r:
                y = arr[l]
                freq[y] -= 1
                l += 1
            ct += r-l+1
        print(ct)
