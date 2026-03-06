class Trie:
    def __init__(self):
        self.root = {}

    def insert(self, word):
        node = self.root
        for ch in word:
            if ch not in node:
                node[ch] = {}
            node = node[ch]


    def dfs(self, node, depth):
        for ch in sorted(node):
            for _ in range(depth):
                print("--", end="")
            print(ch)
            self.dfs(node[ch], depth + 1)

    def trav(self):
        node = self.root
        for ch in sorted(node):
            print(ch)
            self.dfs(node[ch], 1)

T = Trie()
n = int(input())
for _ in range(n):
    cmds = input().split()
    T.insert(cmds[1:])

T.trav()