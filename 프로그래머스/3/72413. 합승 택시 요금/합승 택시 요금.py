# 합승 택시 요금을 최소화 하는 방법
# S,B,A에서 각 지점의 최소 비용을 구한다
# 각 지점부터 S, B, A까지의 비용을 더하고 가장 작은 값을 답으로 한다.

import heapq

def solution(n, s, a, b, fares):
    answer = 0
    
    graph = makeGraph(fares)
    
    aLoad = [float("inf")] * (n + 1)
    bLoad = [float("inf")] * (n + 1)
    sLoad = [float("inf")] * (n + 1)
    
    def dijkstra(start, load):
        load[start] = 0
        q = []
        
        heapq.heappush(q, [start, 0])
        
        while q:
            node, dis = heapq.heappop(q)
            
            if load[node] < dis:
                continue
            
            for e, w in graph[node]:
                update = w + load[node]
                if update < load[e]:
                    load[e] = update
                    heapq.heappush(q, [e, update])
                    
    dijkstra(a, aLoad)
    dijkstra(b, bLoad)
    dijkstra(s, sLoad)
    
    answer = float("inf")
    
    for i in range(1, n + 1):
        pay = 0
        pay = aLoad[i] + bLoad[i] + sLoad[i]
        answer = min(answer, pay)
    
    return answer

def makeGraph(fares):
    graph = {}
    
    for s, e, w in fares:
        if s in graph:
            graph[s].append([e, w])
        else:
            graph[s] = [[e, w]]
        
        if e in graph:
            graph[e].append([s, w])
        else:
            graph[e] = [[s, w]]
            
    return graph