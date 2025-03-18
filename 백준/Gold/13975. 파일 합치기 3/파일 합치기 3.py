import sys
import heapq

t = int(sys.stdin.readline())

answers = []
for i in range(t):
    answer = 0
    k = int(sys.stdin.readline())
    nums = list(map(int, sys.stdin.readline().split()))
    heapq.heapify(nums)

    while len(nums) > 1:
        n1 = heapq.heappop(nums)
        n2 = heapq.heappop(nums)

        answer += n1 + n2

        heapq.heappush(nums, n1 + n2)

    answers.append(answer)

print("\n".join(map(str, answers)))
