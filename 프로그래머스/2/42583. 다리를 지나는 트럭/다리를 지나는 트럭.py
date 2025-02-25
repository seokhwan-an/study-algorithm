# 다리를 건너는 시간을 구하고자한다.
# 다리는 최대 bridge_length대 만큼만 올라갈 수 있다
# 다리는 weight 이하의 무게를 견딜 수 있다

from collections import deque

def solution(bridge_length, weight, truck_weights):
    answer = 0
    ready = deque(truck_weights)
    bridge = deque()
    
    t_count = 0
    t_weight = 0
    while ready:
        answer += 1
        truck = ready[0]
        if t_count < bridge_length and t_weight + truck <= weight:
            ready.popleft()
            t_count += 1
            t_weight += truck
            bridge.append([truck, 0])
        
        for i in range(len(bridge)):
            bridge[i][1] += 1

        if bridge[0][1] >= bridge_length:
            finish = bridge.popleft()
            t_count -= 1
            t_weight -= finish[0]
            
    answer += bridge_length    
        
    return answer

