N, Q = map(int,input().split())
arr = list(map(int, input().split()))
prefix = [0]
for ai in arr:
    prefix.append(prefix[-1]+ai)
ans = []
shift = 0
for _ in range(Q):
    query = list(map(int, input().split()))
    if query[0] == 1:
        shift = (shift+query[1]) % N
    else:
        l = query[1]
        r = query[2]
        l = (l-1+shift)%N
        r = (r-1+shift)%N

        if l<=r:
            ans.append(prefix[r+1] - prefix[l])
        else:
            ans.append(prefix[N] - prefix[l] + prefix[r+1] - prefix[0])

for a in ans:
    print(a)