arr = list(map(int, input().split()))
ans = []
for mask in range(1<<7):
	if mask.bit_count() != 3: continue
	pick = [arr[i] for i in range(7) if (mask>>i) & 1]
	other = [arr[i] for i in range(7) if not (mask>>i) & 1]
	ab = pick[0] + pick[1]
	bc = pick[1] + pick[2]
	ca = pick[2] + pick[0]
	abc = sum(pick)
	if ab in other and bc in other and ca in other and abc in other:
		ans = pick[:]
		break
ans.sort()
print(*ans)