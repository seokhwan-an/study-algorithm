from collections import deque

def solution(maps):
    answer = 0
    graph = []
    for m in maps:
        graph.append(list(m))
    
    start = []
    lever = []
    end = []
    for i in range(len(graph)):
        for j in range(len(graph[0])):
            if graph[i][j] == "S":
                start = [i, j]
            if graph[i][j] == "L":
                lever = [i, j]
            if graph[i][j] == "E":
                end = [i, j]
    sToL = bfs(start, "L", graph)
    lToE = bfs(lever, "E", graph)
    
    if sToL == -1 or lToE == -1:
        return -1
    answer = sToL + lToE
    return answer

def bfs(start, des, graph):
    q = deque()
    visited = [[False] * len(graph[0]) for _ in range(len(graph))]
    arriveTime = -1
    
    q.append([start[0], start[1], 0])
    visited[start[0]][start[1]] = True
    
    dx = [1, 0, -1, 0]
    dy = [0, 1, 0, -1]
    
    while q:
        x, y, time = q.popleft()
        
        if graph[x][y] == des:
            return time
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if nx < 0 or nx >= len(graph) or ny < 0 or ny >= len(graph[0]):
                continue
            
            if graph[nx][ny] != "X" and not visited[nx][ny]:
                visited[nx][ny] = True
                q.append([nx, ny, time + 1])
        
    return arriveTime  
        