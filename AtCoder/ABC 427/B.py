n = int(input())

dp = [1, 1]

def f(x):
    ct = 0
    while x>0:
        ct+=x%10
        x//=10
    return ct

for i in range(1, n):
    dp.append(dp[-1]+f(dp[-1]))

print(dp[n])