n = int(input())
arr = list(map(int, input().split()))

dp = [arr[0]]
for a in arr[1:]:
    dp.append(max(dp[-1]+a, a))

print(max(dp))