from collections import deque

def solution(n, infection, edges, k):
    graph = [[] for _ in range(n + 1)]
    for x, y, t in edges:
        graph[x].append((y, t))
        graph[y].append((x, t))

    answer = 1

    def spread(infected, pipe_type):
        next_infected = infected[:]
        q = deque()

        for i in range(1, n + 1):
            if next_infected[i]:
                q.append(i)

        while q:
            cur = q.popleft()

            for nxt, t in graph[cur]:
                if t != pipe_type:
                    continue
                if next_infected[nxt]:
                    continue
                next_infected[nxt] = True
                q.append(nxt)

        return next_infected

    def count_infected(infected):
        cnt = 0
        for i in range(1, n + 1):
            if infected[i]:
                cnt += 1
        return cnt

    def dfs(depth, infected):
        nonlocal answer

        cnt = count_infected(infected)
        answer = max(answer, cnt)

        if answer == n:
            return
        if depth == k:
            return

        for pipe_type in range(1, 4):
            next_infected = spread(infected, pipe_type)
            dfs(depth + 1, next_infected)

    infected = [False] * (n + 1)
    infected[infection] = True

    dfs(0, infected)

    return answer