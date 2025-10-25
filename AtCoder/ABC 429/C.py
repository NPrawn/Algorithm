import math

n = int(input())
arr = list(map(int, input().split()))
counter = [0 for _ in range(n+1)]
for a in arr:
    counter[a]+=1
ans = 0
for i in range(n+1):
    if counter[i] < 2: continue
    ans += (n-counter[i])*math.comb(counter[i],2)

print(ans)