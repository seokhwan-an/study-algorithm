import sys
from collections import deque

n, m, k = map(int, sys.stdin.readline().split())
graph = [list(map(int, list(sys.stdin.readline().strip()))) for _ in range(n)]


visited = [[[0] * (k + 1) for _ in range(m)] for _ in range(n)]
count = 1

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

q = deque()
visited[0][0][k] = 1
q.append((0, 0, k, count))
answer = -1

while q:
    x, y, kCnt, move = q.popleft()

    if x == n - 1 and y == m - 1:
        answer = move
        break

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if nx < 0 or nx >= n or ny < 0 or ny >= m:
            continue

        if kCnt > 0:
            if graph[nx][ny] == 1:
                if visited[nx][ny][kCnt - 1] == 0:
                    visited[nx][ny][kCnt - 1] = 1
                    q.append((nx, ny, kCnt - 1, move + 1))
            else:
                if visited[nx][ny][kCnt] == 0:
                    visited[nx][ny][kCnt] = 1
                    q.append((nx, ny, kCnt, move + 1))
        else:
            if graph[nx][ny] == 1:
                continue

            if visited[nx][ny][kCnt] == 0:
                visited[nx][ny][kCnt] = 1
                q.append((nx, ny, kCnt, move + 1))

print(answer)