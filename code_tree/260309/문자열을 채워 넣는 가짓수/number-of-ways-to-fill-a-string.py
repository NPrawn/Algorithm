from collections import defaultdict

MOD = 10**9 + 7
class Node:
    def __init__(self):
        self.child = defaultdict(lambda : Node())
        self.end = False

root = Node()
def insert(word):
    node = root
    for ch in word:
        node = node.child[ch]
    node.end = True

T, m = input().split()
n = len(T)
m = int(m)
words = list(input().split())
dp = [0 for _ in range(len(T) + 1)]
for word in words:
    insert(word)

dp[0] = 1
for i in range(n):
    if dp[i] == 0: continue

    node = root
    for j in range(i, n):
        ch = T[j]
        if ch not in node.child: break
        node = node.child[ch]
        if node.end: dp[j+1] = (dp[j+1] + dp[i]) % MOD

print(dp[n])