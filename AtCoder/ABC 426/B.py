from collections import Counter

s = list(input())
s = Counter(s)

print(s.most_common()[1][0])