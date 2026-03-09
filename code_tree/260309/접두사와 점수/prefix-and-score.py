from collections import defaultdict

class Node:
    def __init__(self):
        self.child = defaultdict(lambda : Node())
        self.ct = 0

root = Node()
def insert(word):
    node = root
    for ch in word:
        node = node.child[ch] 
        node.ct += 1

def search(word):
    node = root
    l = 0
    res = 0
    for ch in word:
        node = node.child[ch]
        l += 1
        res = max(res, l*node.ct)
    return res

n = int(input())
words = list(input().split())
for word in words:
    insert(word)

ans = 0
for word in words:
    ans = max(ans, search(word))

print(ans)