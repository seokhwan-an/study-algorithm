import heapq
import sys

input = sys.stdin.read
data = input().splitlines()

n, k = map(int, data[0].split())

# 보석 리스트
stone = []
for i in range(1, n + 1):
    m, v = map(int, data[i].split())
    stone.append((m, v))  # (무게, 가격)

# 가방 리스트
bag = []
for i in range(n + 1, n + 1 + k):
    bag.append(int(data[i]))

# 1. 보석을 무게 기준 오름차순 정렬 (같은 무게일 때 가치는 신경 쓸 필요 없음)
stone.sort()

# 2. 가방을 무게 기준으로 정렬
bag.sort()

# 우선순위 큐 (최대 힙을 사용하여 가장 가치가 높은 보석을 먼저 선택)
pq = []
answer = 0
index = 0  # 보석 리스트에서 탐색할 위치

# 3. 가방을 순회하며 담을 수 있는 보석 중 가장 가치가 높은 보석을 선택
for b in bag:
    # 현재 가방이 담을 수 있는 보석을 힙에 추가
    while index < n and stone[index][0] <= b:
        heapq.heappush(pq, -stone[index][1])  # 최대 힙을 만들기 위해 음수로 저장
        index += 1

    # 가장 가치가 높은 보석 선택
    if pq:
        answer += -heapq.heappop(pq)

print(answer)
