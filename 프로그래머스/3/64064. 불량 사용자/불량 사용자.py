from itertools import combinations

def solution(user_id, banned_id):
    global s
    s = set()
    answer = 0
    n = len(user_id)
    m = len(banned_id)
    for lst in combinations(user_id, m):
        used = [False for _ in range(m)]
        
        def check(s1, s2):
            if len(s1) != len(s2): return False
            ck = True
            for a, b in zip(s1, s2):
                if a=='*' or b=='*': continue
                if a!=b:
                    ck = False
                    break
            return ck

        def dfs(depth):
            global answer
            if depth == m:
                s.add(lst)
                return

            for i in range(m):
                if used[i]: continue
                if not check(lst[depth], banned_id[i]): continue
                used[i] = True
                dfs(depth + 1)
                used[i] = False
            
        dfs(0)
            
        answer = len(s)
    return answer
