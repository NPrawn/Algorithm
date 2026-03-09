from collections import defaultdict

class Node:
    def __init__(self):
        self.child = defaultdict(lambda : Node())

root = Node()
def insert(word):
    node = root
    for ch in word:
        node = node.child[ch]

def search(word):
    node = root
    ct = 0
    for ch in word:
        node =node.child[ch]
        if len(node.child) != 1: ct += 1
    
    return ct

n = int(input())
words = list(input().split())
for word in words:
    insert(word)
for word in words:
    print(search(word), end=" ")