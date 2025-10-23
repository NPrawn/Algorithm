from collections import Counter

pwd = list(input())
k = int(input())
n = len(pwd)-k
ans = 0
for i in range(n):
    arr = []
    for j in range(i,len(pwd),n):
        arr.append(pwd[j])
    cnt = Counter(arr)
    freq = cnt.most_common(1)[0][1]
    ans += len(arr) - freq

print(ans)