n = int(input())
arr = list(map(int, input().split()))

class Node:
    def __init__(self):
        self.child = [None, None]
    
root = Node()

def to_binary(x):
    s = ""
    for i in range(30, -1, -1):
        if x & (1 << i):
            s += "1"
        else:
            s += "0"
    return s

def insert(s):
    node = root
    for ch in s:
        idx = int(ch)
        if node.child[idx] is None:
            node.child[idx] = Node()
        node = node.child[idx]
    
def query(s):
    node = root
    ret = 0
    for ch in s:
        idx = int(ch)
        want = idx ^ 1
        ret <<= 1
        if node.child[want] is not None:
            ret |= 1
            node = node.child[want]
        else:
            node = node.child[idx]
    return ret

for num in arr:
    insert(to_binary(num))

ans = 0
for num in arr:
    ans = max(ans, query(to_binary(num)))

print(ans)