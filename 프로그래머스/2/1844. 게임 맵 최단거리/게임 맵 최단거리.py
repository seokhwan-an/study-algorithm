from collections import deque

def solution(maps):
    answer = bfs(maps)
    
    
    return answer

# 캐릭터는 항상 좌측 상단 위치에서 시작
def bfs(maps):
    visited = [[0] * len(maps[0]) for i in range(len(maps))]
    
    start_x = 0
    start_y = 0
    
    end_x = len(maps) - 1
    end_y = len(maps[0]) - 1
    
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    
    q = deque()
    visited[start_x][start_y] = 1
    q.append([start_x, start_y, 1])
    
    
    while q:
        p = q.popleft()
        
        p_x = p[0]
        p_y = p[1]
        move = p[2]
        
        if (p_x == end_x and p_y == end_y):
            return move
        
        for i in range(4):
            nx = p_x + dx[i]
            ny = p_y + dy[i]
            
            if nx < 0 or nx >= len(maps) or ny < 0 or ny >= len(maps[0]) or maps[nx][ny] == 0:
                continue
            
            if visited[nx][ny] == 0:
                visited[nx][ny] = 1
                q.append([nx, ny, move + 1])
        
    return -1
    
    
