n = int(input())
arr = list(map(int, input().split()))
odd = 0
even = 0
for a in arr:
	if a%2==1: odd+=1
	else: even+=1

ans = 0
while True:
	if even != 0:
		even-=1
		ans+=1
	else:
		if odd>1:
			odd-=2
			ans+=1
		else:
			break
	
	if odd != 0:
		odd-=1
		ans+=1
	else:
		break

print(ans-odd)