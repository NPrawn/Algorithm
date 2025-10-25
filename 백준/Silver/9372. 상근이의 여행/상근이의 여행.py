T = int(input())
ans = []
for _ in range(T):
    N, M = map(int, input().split())
    for _ in range(M):
        input()
    ans.append(N-1)

for e in ans:
    print(e)