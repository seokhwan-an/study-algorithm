import sys
import heapq

n, m, x = map(int, sys.stdin.readline().split())

graph = {}

for i in range(m):
    s, e, w = map(int, sys.stdin.readline().split())

    if s in graph:
       graph[s].append([e, w])
    else:
        graph[s] = [[e, w]]

distances = [[float("inf")] * (n + 1) for _ in range(n + 1)]

def dijkstra(start):
    distances[start][start] = 0
    q = []

    heapq.heappush(q, [0, start])

    while q:
        dis, node = heapq.heappop(q)

        if distances[start][node] < dis:
            continue

        if node not in graph:
            continue

        nexts = graph[node]

        for nextNode, nextDis in nexts:
            updateDis = distances[start][node] + nextDis
            if updateDis < distances[start][nextNode]:
                distances[start][nextNode] = updateDis
                heapq.heappush(q, [updateDis, nextNode])

for i in range(n + 1):
    dijkstra(i)
answer = 0
for i in range(1, n + 1):
    if i == x:
        continue
    total = distances[x][i] + distances[i][x]
    answer = max(answer, total)
print(answer)