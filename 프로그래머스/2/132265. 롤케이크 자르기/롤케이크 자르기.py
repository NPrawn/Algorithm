from collections import Counter

def solution(topping):
    right = Counter(topping)
    left = set()
    answer = 0

    for x in topping[:-1]:
        left.add(x)
        right[x] -= 1
        if right[x] == 0:
            del right[x]

        if len(left) == len(right):
            answer += 1

    return answer