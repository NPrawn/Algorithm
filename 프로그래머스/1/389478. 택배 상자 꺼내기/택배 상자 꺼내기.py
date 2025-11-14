def solution(n, w, num):
    answer = 0
    grid = [[0 for _ in range(w)] for _ in range(105)]
    for i in range(0, n):
        grid[i//w][i%w] = i+1
    for i in range(1, 105, 2):
        grid[i] = grid[i][::-1]
    for i in range(105):
        for j in range(w):
            if grid[i][j]!=num: continue
            while grid[i][j] != 0:
                answer+=1
                i+=1
            break
                
    return answer