# 캐릭터는 중첩된 사각형의 테두리를 따라서 움직인다.
# 캐릭터는 상하 좌우로 움직인다.
# 중첩된 사각형의 테두리인지 확인하는 법
from collections import deque

def solution(rectangle, characterX, characterY, itemX, itemY):
    answer = 0
    board = [[0] * 102 for _ in range(102)]
    
    dx = [1, 0, -1, 0]
    dy = [0, 1, 0, -1]
    
    for x1, y1, x2, y2 in rectangle:
        x1, y1, x2, y2 = x1 * 2, y1 * 2, x2 * 2, y2 * 2
        for i in range(x1, x2 + 1):
            for j in range(y1, y2 + 1):
                board[i][j] = 1
                
    for x1, y1, x2, y2 in rectangle:
        x1, y1, x2, y2 = x1 * 2, y1 * 2, x2 * 2, y2 * 2
        for i in range(x1 + 1, x2):
            for j in range(y1 + 1, y2):
                board[i][j] = 0
                
    q = deque()
    visited = set()
    dx = [1, 0, -1, 0]
    dy = [0, 1, 0, -1]
    
    q.append((characterX * 2, characterY * 2, 0))
    visited.add((characterX * 2, characterY * 2))
    
    while q:
        x, y, move = q.popleft()
        
        if x == itemX * 2 and y == itemY * 2:
            answer = move // 2
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if (nx, ny) not in visited and board[nx][ny] == 1:
                visited.add((nx, ny))
                q.append((nx, ny, move + 1))
        
    return answer