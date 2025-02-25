from collections import deque

def solution(priorities, location):
    answer = 1
    sorted_p = sorted(priorities, reverse=True)
    print(sorted_p)
    
    work = []
    for i in range(len(priorities)):
        work.append([i, priorities[i]])
        
    q = deque(work)
    
    while q:
        work = q.popleft()
        if work[1] == sorted_p[0]:
            if work[0] == location:
                break
            sorted_p.pop(0)
            answer += 1
            continue
        q.append([work[0], work[1]])
    
    return answer