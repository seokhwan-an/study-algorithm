import sys
import heapq

v, e = map(int, sys.stdin.readline().split())
start = int(sys.stdin.readline())

graph = {}

for i in range(e):
    s, e, w = map(int, sys.stdin.readline().split())
    if s in graph:
        graph[s].append([e, w])
    else:
        graph[s] = [[e, w]]


distances = [float("INF")] * (v + 1)
def dijkstra(start):
    distances[start] = 0

    q = []
    heapq.heappush(q, [0, start])

    while q:
        dis, node = heapq.heappop(q)

        if distances[node] < dis:
            continue

        if node not in graph:
            continue
        nexts = graph[node]

        for nextNode, nextDis in nexts:
            updateDis = distances[node] + nextDis
            if updateDis < distances[nextNode]:
                distances[nextNode] = updateDis
                heapq.heappush(q, [updateDis, nextNode])

dijkstra(start)
distances = [str(distances[i]).upper() for i in range(1, len(distances))]
print("\n".join(distances))