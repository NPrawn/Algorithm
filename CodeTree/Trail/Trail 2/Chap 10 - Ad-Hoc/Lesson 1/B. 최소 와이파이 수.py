n, m = map(int, input().split())
arr = list(map(int, input().split()))
m*=2
m+=1
ans = 0
for i in range(n):
	if arr[i] == 0: continue
	ans += 1
	for j in range(i, min(n,i+m)):
		arr[j] = 0
	i+=m

print(ans)