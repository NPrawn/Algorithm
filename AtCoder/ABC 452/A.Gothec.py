m, d = map(int, input().split())

ans = 'No'
if m==1 and d==7: ans = 'Yes'
if m==3 and d==3: ans = 'Yes'
if m==5 and d==5: ans = 'Yes'
if m==7 and d==7: ans = 'Yes'
if m==9 and d==9: ans = 'Yes'

print(ans)