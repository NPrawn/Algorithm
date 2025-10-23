n = int(input())

arr = list(map(int,input().split()))

l,r=0,1
ans = []
while l<r:
    while r<n and arr[l]==arr[r]:
        r+=1
    if r==n: break
    for _ in range(r-l):
        ans.append(r+1)
    l, r = r, r+1

while len(ans)<n:
    ans.append(-1)

print(*ans)