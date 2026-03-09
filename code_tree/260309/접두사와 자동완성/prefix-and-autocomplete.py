from collections import defaultdict

class Node:
    def __init__(self):
        self.child = defaultdict(lambda : Node())
        self.end = 0

root = Node()
def insert(word):
    node = root
    for ch in word:
        node = node.child[ch]
    node.end += 1

def search(word):
    node = root
    ct = 0
    for i, ch in enumerate(word):
        node = node.child[ch]
        if len(node.child) == 1 and node.end == 0: continue
        ct += 1
    
    return ct

n = int(input())
words = list(input().split())
for word in words:
    insert(word)
for word in words:
    print(search(word), end=" ")