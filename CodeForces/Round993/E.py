T = int(input())
ans = []

for _ in range(T):
    k, l1, r1, l2, r2 = map(int, input().split())

    count = 0
    pow = 1

    while True:
        min_x = max(l1, (l2+pow-1)//pow)
        max_x = min(r1,r2//pow)
        if min_x <= max_x:
            count += (max_x - min_x + 1)
        
        if pow > r2 // k:
            break
        pow*=k
    
    ans.append(count)

for e in ans:
    print(e)