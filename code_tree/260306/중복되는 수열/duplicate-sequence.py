class Trie:

    def __init__(self):
        self.root = {}
        self.END = "*"
    
    def insert(self, word):
        node = self.root
        ans = 1
        for ch in word:
            if ch not in node:
                node[ch] = {}
            node = node[ch]
            if self.END in node: ans = 0
        node[self.END] = True
        return ans

t = Trie()
n = int(input())
ans = 1
for _ in range(n):
    s = input()
    ans = min(ans, t.insert(s))

print(ans)