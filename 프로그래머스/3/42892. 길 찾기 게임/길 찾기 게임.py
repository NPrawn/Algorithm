import sys
sys.setrecursionlimit(10 ** 6)
from collections import defaultdict

def solution(nodeinfo):
    answer = [[], []]
    n = len(nodeinfo)
    mapping = {}
    for i in range(n):
        x, y = nodeinfo[i]
        mapping[(x,y)] = i+1
    left = defaultdict(lambda: [])
    right = defaultdict(lambda: [])
    
    def solve(nodes):
        if len(nodes) == 0: return
        nodes.sort(key=lambda x: -x[1])
        node = nodes[0]
        x, y = node
        while len(nodes) > 1:
            nx, ny = nodes.pop()
            if nx < x:
                left[(x,y)].append((nx,ny))
            else:
                right[(x,y)].append((nx,ny))

        solve(left[(x,y)])
        
        solve(right[(x,y)])
    solve(nodeinfo)
    
    def preorder(node):
        x, y = node
        answer[0].append(mapping[(x,y)])
        if len(left[(x,y)]) > 0:
            preorder(left[(x,y)][0])
        if len(right[(x,y)]) > 0:
            preorder(right[(x,y)][0])

    
    def postorder(node):
        x, y = node
        if len(left[(x,y)]) > 0:
            postorder(left[(x,y)][0])
        if len(right[(x,y)]) > 0:
            postorder(right[(x,y)][0])
        answer[1].append(mapping[(x,y)])
        
    x, y = nodeinfo[0]
    preorder((x,y))
    postorder((x,y))
    return answer