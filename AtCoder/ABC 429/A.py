n, m = map(int, input().split())

for i in range(n):
    print('OK' if i<m else 'Too Many Requests')