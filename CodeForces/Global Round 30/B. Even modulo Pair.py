# T = int(input())
# ans = []
# for _ in range(T):
# 	n = int(input())
# 	arr = list(map(int, input().split()))
#
#
#
# 5     7, 9 / 12, 14 / 17, 19 / 22, 24

# 17    19,21,23,25,27,29,31,33 /

for i in range(18, 100):
	if i % 17 % 2 == 0:
		print(i)