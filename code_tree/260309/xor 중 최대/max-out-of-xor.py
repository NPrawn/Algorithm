class Node:
    def __init__(self):
        self.child = [None, None]
    
root = Node()

def insert(num):
    node = root
    for bit in range(30, -1, -1):
        b = (num >> bit) & 1
        if node.child[b] is None:
            node.child[b] = Node()
        node = node.child[b]

def query(num):
    node = root
    ret = 0
    
    for bit in range(30, -1, -1):
        b = (num >> bit) & 1
        want = b ^ 1
        
        if node.child[want] is not None:
            ret |= (1 << bit)
            node = node.child[want]
        else:
            node = node.child[b]
    
    return ret

n = int(input())
arr = list(map(int, input().split()))
insert(arr[0])
ans = 0
for i in range(1, n):
    ans = max(ans, query(arr[i]))
    insert(arr[i])

print(ans)