T = int(input())
ans = []
dp = [0,1,1,1,2,2,3,4,5,7,9]

for i in range(11, 105):
    dp.append(dp[-1]+dp[-5])

for _ in range(T):
    n = int(input())
    ans.append(dp[n])
    
for e in ans:
    print(e)