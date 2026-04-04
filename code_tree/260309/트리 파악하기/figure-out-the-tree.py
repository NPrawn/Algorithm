from collections import defaultdict

class Node:
    def __init__(self):
        self.child = defaultdict(lambda : Node())

root = Node()
def insert(word):
    node = root
    for ch in word:
        node = node.child[ch]

def dfs(node, depth):
    for word in sorted(node.child):
        for _ in range(depth):
            print('--', end='')
        print(word)
        dfs(node.child[word], depth + 1)


n = int(input())
for _ in range(n):
    cmds = input().split()
    insert(cmds[1:])

dfs(root, 0)