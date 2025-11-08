n = int(input())
parts = [[0,0,0]]
body = 0
ans = 0
for _ in range(n):
	w, h, b = map(int, input().split())
	body+=w
	ans+=b
	if b-h>=0: continue
	parts.append([w*2,h-b])



dp = [[0]*(body+1) for _ in range(len(parts)+1)]
for i in range(1, len(parts)):
	for j in range(1, body+1):
		weight = parts[i][0]
		value = parts[i][1]
		if j < weight:
			dp[i][j] = dp[i - 1][j]
		else:
			dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weight] + value)
print(dp[-2][-1]+ans)