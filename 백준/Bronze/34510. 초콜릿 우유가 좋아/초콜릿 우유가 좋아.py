h1, h2, h3 = map(int,input().split())
N = int(input())

k = h3+h2+h3

ans = 0
ans += (N//2)*k + (N%2)*(h1+h2+h3)

print(ans)