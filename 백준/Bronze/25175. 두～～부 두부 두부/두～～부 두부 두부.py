n,m,k = map(int,input().split())

if k>3: ans = (m+k-3-1)%n+1
elif k<3: ans = (m-1-(3-k))%n+1
else: ans = m

print(ans)