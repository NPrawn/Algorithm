n = int(input())
p = list(map(int, input().split()))
x = int(input())
s = set()
p[x] = -2
s.add(x)

while True:
    remove = []
    for i in range(n):
        if p[i] in s:
            remove.append(i)
    
    if remove:
        for e in remove:
            s.add(e)
            p[e] = -2
    else:
        break

s = set(i for i in range(n))
for i, a in enumerate(p):
    if a==-2:
        s.discard(i)
    s.discard(a)

print(len(s))
