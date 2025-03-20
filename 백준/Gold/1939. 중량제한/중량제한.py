import sys
import heapq

n, m = map(int, sys.stdin.readline().split())

graph = {}

for i in range(m):
    s, e, w = map(int, sys.stdin.readline().split())

    if s not in graph:
        graph[s] = [[e, w]]
    else:
        graph[s].append([e, w])

    if e not in graph:
        graph[e] = [[s, w]]
    else:
        graph[e].append([s, w])

start, target = map(int, sys.stdin.readline().split())

distances = [float('-inf')] * (n + 1)

def dijkstra(start):
    distances[start] = 1_000_000_000
    q = []
    heapq.heappush(q, (-1 * 1_000_000_000, start))

    while q:
        dis, node = heapq.heappop(q)
        dis = -1 * dis
        if distances[node] > dis:
            continue

        if node not in graph:
            continue

        nexts = graph[node]
        for nextNode, nextDis in nexts:
            updateDis = min(dis, nextDis)
            if updateDis > distances[nextNode]:
                distances[nextNode] = updateDis
                heapq.heappush(q, (-1 * updateDis, nextNode))

dijkstra(start)
print(distances[target])