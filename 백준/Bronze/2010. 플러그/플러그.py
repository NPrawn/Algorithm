import sys

a = int(input())
sum = 1
for i in range(a):
    b=int(sys.stdin.readline())
    sum+=b

print(sum-a)