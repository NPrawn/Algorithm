T = int(input())

for _ in range(T):
    n, k, x = map(int, input().split())
    arr = list(map(int,input().split()))
    arr.sort()

    def cal(mid):
        cnt, cuts = 0, 0
        for a in arr:
            val = a
            stk = [val]
            while stk and cuts < k:
                v = stk.pop()
                if v<mid: continue
                cnt+=1
                if cuts < k:
                    cuts+=1
                    stk.append(v/2)
                    stk.append(v/2)
        return cnt

    low, high = 0, max(arr)
    ans = 1
    while low<=high:
        mid = (low + high) // 2
        if cal(mid) >= x:
            ans = mid
            low = mid + 1
        else:
            high = mid - 1

    print(ans)