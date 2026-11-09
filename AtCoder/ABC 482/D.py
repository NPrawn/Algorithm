n = int(input())
x = list(map(int, input().split()))

if n == 1:
    print(0)
else:
    for k in range(n):
        ans = float('inf')

        if k > 0:
            left = max(x[k] - x[0], x[-1] - x[k-1]) // 2
            ans = min(ans, left)

        if k < n-1:
            right = max(x[k+1] - x[0], x[-1] - x[k]) // 2
            ans = min(ans, right)

        print(ans)