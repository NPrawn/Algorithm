n, m = map(int, input().split())
a = set(map(int, input().split()))
b = set(map(int, input().split()))

res = []

for x in a:
    if x not in b: res.append(x)

res.sort()
print(len(res))
for x in res:
    print(x, end=' ')