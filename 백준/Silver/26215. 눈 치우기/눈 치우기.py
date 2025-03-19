import sys
import heapq

n = int(sys.stdin.readline())
snows = list(map(int, sys.stdin.readline().split()))

q = []

for snow in snows:
    heapq.heappush(q, -1 * snow)

answer = 0
while q:
    answer += 1
    if len(q) > 1:
        h1 = -1 * heapq.heappop(q)
        h2 = -1 * heapq.heappop(q)

        if h1 - 1 > 0:
            heapq.heappush(q, -1 * (h1 - 1))

        if h2 - 1 > 0:
            heapq.heappush(q, -1 * (h2 - 1))
    else:
        h = -1 * heapq.heappop(q)

        if h - 1:
            heapq.heappush(q, -1 * (h - 1))

if answer > 1440:
    print(-1)
else:
    print(answer)