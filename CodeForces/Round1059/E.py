T = int(input())
ans = []
for _ in range(T):
    n, k = map(int, input().split())
    arr = list(map(int, input().split()))
    unused = None
    s = [0 for _ in range(n+1)]
    for val in arr:
        s[val] = 1
    for idx, val in enumerate(s):
        if idx==0: continue
        if val==0: unused = idx
    res = []
    nums = [1,2,3]
    a = n-2
    b = n-1
    while arr[a] == arr[b] and a>=1:
        a-=1
    a = arr[a]
    b = arr[b]
    if unused == None:
        for _ in range(k):
            for c in nums:
                if c != a and c != b:
                    res.append(c)
                    a, b = b, c
                    break
    else:
        res.append(unused)
        a, b = b, unused
        for _ in range(k-1):
            for c in nums:
                if c != a and c != b:
                    res.append(c)
                    a, b = b, c
                    break
    ans.append(res)

for e in ans:
    print(*e)