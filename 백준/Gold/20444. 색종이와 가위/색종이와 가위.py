n, k = map(int, input().split())

ans = 0
st, en = 0, n//2
while st<=en:
    mid = (st+en)//2
    a = mid
    b = n-a
    res = (a+1) * (b+1)
    if res == k: ans=1; break
    elif res<k: st=mid+1
    else: en=mid-1

print("YES" if ans else "NO")