class Node:
    def __init__(self):
        self.child = {}
        self.ct = 0

class Trie:
    def __init__(self):
        self.root = Node()
    
    def insert(self, word):
        node = self.root
        for ch in word:
            if ch not in node.child:
                node.child[ch] = Node()
            node = node.child[ch]
            node.ct += 1
    
    def search(self, word):
        node = self.root
        for ch in word:
            if ch not in node.child:
                node.child[ch] = Node()
            node = node.child[ch]
            print(node.ct, end=' ')

n, m = map(int, input().split())
t = Trie()
for word in list(input().split()):
    t.insert(word)

t.search(input())