from collections import deque

def solution(n, computers):
    answer = 0
    
    graph = {}
    visited = [False] * n
    for i in range(len(computers)):
        graph[i] = []
        computer = computers[i]
        for j in range(len(computer)):
            if i == j:
                continue
            connect = computer[j]
            if connect == 1:
                graph[i].append(j)
                
    for i in range(0, n):
        if not visited[i]:
            answer += 1
            visited[i] = True
            q = deque()
            q.append(i)
    
            while q:
                p = q.popleft()
                
                nexts = graph[p]
                
                for next in nexts:
                    if not visited[next]:
                        visited[next] = True
                        q.append(next)
    
    return answer