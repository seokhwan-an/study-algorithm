import heapq

def solution(operations):
    answer = []
    max_h = []
    min_h = []
    for operation in operations:
        command, num = operation.split()

        if command == "D":
            if num == "1":
                if len(max_h) != 0:
                    delete = -1 * heapq.heappop(max_h)
                    min_h.remove(delete)
            else:  
                if len(min_h) != 0:
                    delete = -1 * heapq.heappop(min_h)
                    max_h.remove(delete)   
                
        elif command == "I": 
            heapq.heappush(max_h, -1 * int(num))
            heapq.heappush(min_h, int(num))
            
    if len(min_h) == 0:
        return [0, 0]
    
    max_num = -1 * heapq.heappop(max_h)
    min_num = heapq.heappop(min_h)
    return [max_num, min_num]