from collections import deque

def solution(prices):
    answer = [0] * len(prices)
    
    q = deque(prices)
    
    index = 0
    while q:
        target = q.popleft()
        count = 0
        for next in q:
            count += 1
            if next < target:
                break
        answer[index] = count
        index += 1
    return answer
