def solution(jobs):
    global heap, size
    heap = [[] for _ in range(505)]
    size = 1
    def push(x):
        global heap, size
        heap[size] = x
        idx = size
        size += 1

        while (idx > 1):
            parent = idx//2
            if heap[idx][0] < heap[parent][0]:
                heap[idx], heap[parent] = heap[parent], heap[idx]
            elif heap[idx][0] == heap[parent][0] and heap[idx][1] < heap[parent][1]:
                heap[idx], heap[parent] = heap[parent], heap[idx]
            elif heap[idx][0] == heap[parent][0] and heap[idx][1] == heap[parent][1] and heap[idx][2] < heap[parent][2]:
                heap[idx], heap[parent] = heap[parent], heap[idx]

            idx = parent

    def pop():
        global heap, size
        res = heap[1]
        heap[0] = heap[size-1]
        size-=1
        idx = 0
        while idx < size:
            smallest = idx
            left = idx*2
            right = left+1

            if left < size:
                if heap[smallest][0] > heap[left][0]:
                    smallest = left
                elif heap[smallest][0] == heap[left][0] and heap[left][1] < heap[smallest][1]:
                    smallest = left
                elif heap[smallest][0] == heap[left][0] and heap[smallest][1] == heap[left][1] and heap[left][2] < heap[smallest][2]:
                    smallest = left

            if right < size:
                if heap[smallest][0] > heap[right][0]:
                    smallest = right
                elif heap[smallest][0] == heap[right][0] and heap[right][1] < heap[smallest][1]:
                    smallest = right
                elif heap[smallest][0] == heap[right][0] and heap[smallest][1] == heap[right][1] and heap[right][2] < heap[smallest][2]:
                    smallest = right

            if idx == smallest: break
            heap[idx], heap[smallest] = heap[smallest], heap[idx]
            idx = smallest
        return res
    
    answer = 0
    for i, job in enumerate(jobs):
        job.append(i)
    
    
    jobs.sort(key = lambda x: x[0])
    idx = 0
    t = 0
    while t < 1000005:
        while (idx < len(jobs) and jobs[idx][0] <= t):
            job = jobs[idx]
            push([job[1], job[0], job[2]])
            idx+=1
        if (size > 1):
            runningTime, start, no = pop()
            t += runningTime
            answer += t-start
        else:
            t += 1
            
    return answer//len(jobs)