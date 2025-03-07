# 다익스트라 문제 sources에서 destination을 구하는 것이 아닌 
# destination에서 sources 까지의 최단 거리를 구하고 이를 인덱스로 보고 답 구하기

# 다익스트라 구현 방식
# 다익스트
# 1. 모든 노드의 거리를 최대값 float("inf")로 설정
# 2. 자신의 노드 위치는 0으로 변경

from collections import deque

def solution(n, roads, sources, destination):
    answer = []
    graph = changeGraph(roads)
    
    distances = dajistra(destination, graph, n)
    
    for source in sources:
        if distances[source] == float("inf"):
            answer.append(-1)
        else:
            answer.append(distances[source])
    
    return answer

def changeGraph(roads):
    graph = {}
    for road in roads:
        start, end = road[0], road[1]
        if start in graph:
            graph[start].append(end)
        else:
            graph[start] = [end]
        
        if end in graph:
            graph[end].append(start)
        else:
            graph[end] = [start]
    return graph

def dajistra(des, graph, n):
    distances = [float("inf")] * (n + 1)
    
    distances[des] = 0
    
    q = deque()
    q.append([des, 0])
    
    while q:
        des, dis = q.popleft()
    
        
        if distances[des] < dis:
            continue
        
        nexts = graph[des]
        
        for n in nexts:
            distance = dis + 1
            if distance < distances[n]:
                distances[n] = distance
                q.append([n, distance])
            
    
    return distances