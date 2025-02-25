from collections import deque

def solution(progresses, speeds):
    answer = []
    q = deque()

    for i in range(len(progresses)):
        q.append([progresses[i], i])
    
    while q:
        
        for i in range(len(q)):
            info = q.popleft()
            progress = info[0]
            index = info[1]
            
            progress += speeds[index]
            q.append([progress, index])
            
        count = 0    
        for i in range(len(q)):
            info = q[0]
            progress = info[0]
            
            if progress >= 100:
                q.popleft()
                count += 1;
            else:
                break;
            
        
            
        if count > 0:
            answer.append(count)
        
    return answer
