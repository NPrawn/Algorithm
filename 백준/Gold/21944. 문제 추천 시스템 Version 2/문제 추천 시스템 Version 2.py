import sys
import heapq
from collections import defaultdict

input = sys.stdin.readline

N = int(input())

info = {}  # P -> (L, G)

min_all = []
max_all = []

min_g = defaultdict(list)
max_g = defaultdict(list)

# Level is 1..100
min_l = [[] for _ in range(101)]
max_l = [[] for _ in range(101)]

def add_problem(p, l, g):
    info[p] = (l, g)

    heapq.heappush(min_all, (l, p))
    heapq.heappush(max_all, (-l, -p))

    heapq.heappush(min_g[g], (l, p))
    heapq.heappush(max_g[g], (-l, -p))

    heapq.heappush(min_l[l], p)
    heapq.heappush(max_l[l], -p)

def clean_min_all():
    while min_all:
        l, p = min_all[0]
        cur = info.get(p)
        if cur and cur[0] == l:
            return p
        heapq.heappop(min_all)
    return None

def clean_max_all():
    while max_all:
        nl, np = max_all[0]
        l, p = -nl, -np
        cur = info.get(p)
        if cur and cur[0] == l:
            return p
        heapq.heappop(max_all)
    return None

def recommend_group(g, x):
    if x == 1:  # hardest: max level, then max p
        h = max_g[g]
        while h:
            nl, np = h[0]
            l, p = -nl, -np
            cur = info.get(p)
            if cur and cur == (l, g):
                return p
            heapq.heappop(h)
    else:       # easiest: min level, then min p
        h = min_g[g]
        while h:
            l, p = h[0]
            cur = info.get(p)
            if cur and cur == (l, g):
                return p
            heapq.heappop(h)
    return -1

def recommend_all(x):
    if x == 1:
        p = clean_max_all()
        return p if p is not None else -1
    else:
        p = clean_min_all()
        return p if p is not None else -1

def recommend3(x, L):
    if x == 1:
        # minimum level >= L, tie: smallest p
        for lv in range(L, 101):
            h = min_l[lv]
            while h:
                p = h[0]
                cur = info.get(p)
                if cur and cur[0] == lv:
                    return p
                heapq.heappop(h)
        return -1
    else:
        # maximum level < L, tie: largest p
        for lv in range(L - 1, 0, -1):
            h = max_l[lv]
            while h:
                p = -h[0]
                cur = info.get(p)
                if cur and cur[0] == lv:
                    return p
                heapq.heappop(h)
        return -1

for _ in range(N):
    P, L, G = map(int, input().split())
    add_problem(P, L, G)

M = int(input())
out = []

for _ in range(M):
    cmd = input().split()
    if cmd[0] == "add":
        P = int(cmd[1]); L = int(cmd[2]); G = int(cmd[3])
        add_problem(P, L, G)

    elif cmd[0] == "solved":
        P = int(cmd[1])
        if P in info:
            del info[P]

    elif cmd[0] == "recommend":
        G = int(cmd[1]); x = int(cmd[2])
        out.append(str(recommend_group(G, x)))

    elif cmd[0] == "recommend2":
        x = int(cmd[1])
        out.append(str(recommend_all(x)))

    else:  # recommend3
        x = int(cmd[1]); L = int(cmd[2])
        out.append(str(recommend3(x, L)))

print("\n".join(out))
