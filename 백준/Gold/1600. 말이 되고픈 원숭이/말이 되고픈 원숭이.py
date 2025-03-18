import sys
from collections import deque

# 입력 받기
k = int(sys.stdin.readline())
w, h = map(int, sys.stdin.readline().split())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(h)]

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

hx = [2, 1, -1, -2, 2, 1, -1, -2]
hy = [1, 2, 2, 1, -1, -2, -2, -1]

visited = [[[False] * (k + 1) for _ in range(w)] for _ in range(h)]

q = deque()
q.append((0, 0, k, 0))
visited[0][0][k] = True
answer = -1

while q:
    x, y, kCnt, move = q.popleft()

    if x == h - 1 and y == w - 1:
        answer = move
        break

    for i in range(4):
        nx, ny = x + dx[i], y + dy[i]
        if 0 <= nx < h and 0 <= ny < w and not visited[nx][ny][kCnt] and graph[nx][ny] == 0:
            visited[nx][ny][kCnt] = True
            q.append((nx, ny, kCnt, move + 1))

    if kCnt > 0:
        for i in range(8):
            nx, ny = x + hx[i], y + hy[i]
            if 0 <= nx < h and 0 <= ny < w and not visited[nx][ny][kCnt - 1] and graph[nx][ny] == 0:
                visited[nx][ny][kCnt - 1] = True
                q.append((nx, ny, kCnt - 1, move + 1))

print(answer)
