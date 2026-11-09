grid = [list(input()) for _ in range(5)]
ans = 5

for i in range(5):
    ct = 0
    for j in range(5):
        if grid[i][j] == '.':
            ct += 1
    ans = min(ans, ct)

for j in range(5):
    ct = 0
    for i in range(5):
        if grid[i][j] == '.': ct += 1
    ans = min(ans, ct)

ct = 0
for i in range(5):
    if grid[i][i] == '.': ct += 1
ans = min(ans, ct)

ct = 0
for i in range(5):
    if grid[i][4-i] == '.': ct += 1
ans = min(ans, ct)

print(ans)