n = int(input())
arr = list(map(int, input().split()))

arr.sort()
ans = float('inf')

for i in range(n-1):
    for j in range(i+1, n):
        k = arr[i] + arr[j]
        l, r = 0, n-1
        while l<r:
            while (l==i or l==j): l+=1
            while (r==i or r==j): r-=1
            if l==n or r==-1 or l>=r: break
            x = arr[l] + arr[r]
            ans = min(ans, abs(k-x))
            if (x < k): l+=1
            else: r-=1

print(ans)