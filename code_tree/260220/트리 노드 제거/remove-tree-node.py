n = int(input())
p = list(map(int, input().split()))
x = int(input())
s = set()
s.add(x)

while True:
    remove = []
    for i in range(n):
        if p[i] in s:
            remove.append(i)
    
    if remove:
        for e in remove:
            s.add(e)
            p[e] = -1
    else:
        break

s = set()
for i in range(n):
    if p[i] == -1:
        n-=1
        continue
    s.add(p[i])

print(n-len(s))