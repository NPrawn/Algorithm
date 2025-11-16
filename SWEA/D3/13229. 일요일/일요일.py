T = int(input())
ans = []
for _ in range(T):
	s = input()
	if s=='SUN': ans.append(7)
	elif s=='MON': ans.append(6)
	elif s=='TUE': ans.append(5)
	elif s=='WED': ans.append(4)
	elif s=='THU': ans.append(3)
	elif s=='FRI': ans.append(2)
	elif s=='SAT': ans.append(1)

for i, e in enumerate(ans):
	print(f'#{i+1} {e}')