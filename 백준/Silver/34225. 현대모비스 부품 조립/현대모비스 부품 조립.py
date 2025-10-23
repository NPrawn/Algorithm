n = int(input())
arr = []
for i, num in enumerate(list(map(int,input().split()))):
    arr.append([num, i+1])
arr.sort()
r = n-1

dp = [[arr[r][0], arr[r][0], arr[r][0]]]
ans = []
for e in reversed(arr[0:r]):
    dp.append([dp[-1][0] + e[0], e[0], arr[r][0]])

res = []
for e in dp:
    res.append(sum(e))
l = r - res.index(max(res))
for e in arr[l:r+1]:
    ans.append(e[1])
print(len(ans))
print(*ans)