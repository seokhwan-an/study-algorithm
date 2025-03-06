import heapq

def solution(n, works):
    answer = 0
    
    q = []
    for work in works:
        heapq.heappush(q, -1 * work)
    
    while n:
        work = -1 * heapq.heappop(q)
        work -= 1
        if work < 0:
            work = 0
        heapq.heappush(q, -1 * work)
        
        n -= 1
        
    while q:
        work = -1 * heapq.heappop(q)
        
        answer += work * work
    return answer