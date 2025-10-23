T = int(input())
ans = []
for _ in range(T):
    n = int(input())
    arr = list(map(int, input().split()))
    ct=0
    ct+=(arr.count(-1)%2) * 2
    ct+=arr.count(0)
    ans.append(ct)

for e in ans:
    print(e)