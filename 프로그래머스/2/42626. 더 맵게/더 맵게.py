import heapq

def solution(scoville, K):
    answer = 0
    arr = []
    for s in scoville:
        heapq.heappush(arr, s)
    
    while len(arr) > 1:
        if arr[0] >= K:
            break
        
        answer += 1
        min1 = heapq.heappop(arr)
        min2 = heapq.heappop(arr)
        
        new_food = min1 + (min2 * 2)
        heapq.heappush(arr, new_food)
        
    if arr[0] < K:
        return -1
    return answer