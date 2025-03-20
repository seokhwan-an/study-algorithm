import sys
import heapq

n = int(sys.stdin.readline())
m = int(sys.stdin.readline())

graph = {}

for _ in range(m):
    s, e, w = map(int, sys.stdin.readline().split())
    if s not in graph:
        graph[s] = [(e, w)]
    else:
        graph[s].append((e, w))

distances = [[float("inf")] * (n + 1) for _ in range(n + 1)]

def dijkstra(start):
    distances[start][start] = 0
    q = []
    heapq.heappush(q, (start, 0))

    while q:
        node, dis = heapq.heappop(q)

        if distances[start][node] < dis:
            continue

        if node not in graph:
            continue

        for nextNode, nextDis in graph[node]:
            updateDis = distances[start][node] + nextDis
            if updateDis < distances[start][nextNode]:
                distances[start][nextNode] = updateDis
                heapq.heappush(q, (nextNode, updateDis))
for i in range(1, n + 1):
    dijkstra(i)
answer = []

for i in range(1, n + 1):
    d = distances[i][1:]
    for j in range(n):
        if d[j] == float("inf"):
            d[j] = 0
    answer.append(" ".join(map(str, d)))

print("\n".join(answer))