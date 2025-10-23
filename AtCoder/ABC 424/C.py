n = int(input())

arr = [set() for _ in range(n+1)]
stk = []

for i in range(1, n+1):
    a, b = map(int, input().split())
    if a==0:
        stk.append(i)
        continue
    arr[a].add(i)
    arr[b].add(i)

learned = [0 for _ in range(n+1)]
while stk:
    cur = stk.pop()
    if learned[cur] == 1: continue
    learned[cur] = 1
    for e in arr[cur]:
        stk.append(e)

print(learned.count(1))