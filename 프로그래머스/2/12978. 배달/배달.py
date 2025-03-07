# 1번 마을에서 배달을 하려고 한다.
# 다익스트라 문제
# 1번 지점에서 모든 점까지의 최단 시간을 계산
# 이후 k보다 작은 개수 추가

import heapq

def solution(N, road, K):
    answer = 0
    
    graph = {}
    
    for start, end, dis in road:
        if start in graph:
            graph[start].append([end, dis])
        else:
            graph[start] = [[end, dis]]
        
        if end in graph:
            graph[end].append([start, dis])
        else:
            graph[end] = [[start, dis]]
    
    distance = dijkstra(graph, 1, N)
    
    for i in range(1, len(distance)):
        if distance[i] <= K:
            answer += 1

    return answer

def dijkstra(graph, start, N):
    totalDis = [float("inf")] * (N + 1)
    totalDis[start] = 0
    
    q = []
    heapq.heappush(q, [0, start])
    while q:
        c_dis, des = heapq.heappop(q)
        
        if totalDis[des] < c_dis:
            continue
        
        nexts = graph[des]
        
        for n in nexts:
            distance = c_dis + n[1]
            if distance < totalDis[n[0]]:
                totalDis[n[0]] = distance
                heapq.heappush(q, [distance, n[0]])
    return totalDis
    
    