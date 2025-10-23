T = int(input())
ans = []

for _ in range(T):
    n, k = map(int, input().split())
    arr = list(map(int, input()))
    ct = 0
    for i in range(n):
        if arr[i] == 0: continue
        st = max(0, i-k+1)
        can = True
        for j in range(st, i):
            if arr[j] == 1:
                can = False
                break
        if can: ct+=1
    
    ans.append(ct)

for e in ans:
    print(e)