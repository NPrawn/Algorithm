N = int(input())

works = []
for _ in range(N):
    d, t = map(int, input().split())
    works.append([d, t])

works.sort(key=lambda x: x[1], reverse=True)


day = works[0][1]

for d, t in works:
    day = min(day, t) - d

print(day)