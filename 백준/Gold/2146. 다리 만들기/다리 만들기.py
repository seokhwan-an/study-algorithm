import sys
from collections import deque

n = int(sys.stdin.readline())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

visited = [[0] * n for _ in range(n)]

islandId = 1
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
for i in range(n):
    for j in range(n):
        if visited[i][j] == 0 and graph[i][j] == 1:
            graph[i][j] = islandId
            q = deque()
            q.append((i, j))
            visited[i][j] = 1

            while q:
                x, y = q.popleft()

                for k in range(4):
                    nx = x + dx[k]
                    ny = y + dy[k]

                    if nx < 0 or nx >= n or ny < 0 or ny >= n:
                        continue

                    if visited[nx][ny] == 0 and graph[nx][ny] != 0:
                        visited[nx][ny] = 1
                        graph[nx][ny] = islandId
                        q.append((nx, ny))

            islandId += 1

answer = float('inf')

def isNear(x, y):
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if nx < 0 or nx >= n or ny < 0 or ny >= n:
            continue
        if graph[nx][ny] != 0:
            return True
    return False
available = []
# 0을 기준으로 주번에 땅 id가 있는지 확인하고 탐색
for i in range(n):
    for j in range(n):
        if graph[i][j] == 0 and isNear(i, j):
            count = 1
            check = set()
            visited = [[0] * n for _ in range(n)]
            q = deque()

            visited[i][j] = 1
            q.append((i, j, 0, count))
            while q:
                x, y, id, c = q.popleft()


                if id != 0:
                    if id in check:
                        continue

                    check.add(id)

                    if len(check) == 2:
                        answer = min(answer, c)
                        break

                for k in range(4):
                    nx = x + dx[k]
                    ny = y + dy[k]

                    if nx < 0 or nx >= n or ny < 0 or ny >= n:
                        continue

                    if visited[nx][ny] == 0:
                        visited[nx][ny] = 1
                        if graph[nx][ny] == 0:
                            q.append((nx, ny, 0, c + 1))
                        else:
                            q.append((nx, ny, graph[nx][ny], c))



print(answer)
