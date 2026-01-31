n = int(input())

fi = [0,1,1]

for _ in range(2, n+1):
    fi.append(fi[-1] + fi[-2])

print(fi[n])