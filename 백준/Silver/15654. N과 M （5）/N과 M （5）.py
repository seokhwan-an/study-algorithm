n, m = map(int, input().split())

nums = list(map(int, input().split()))
nums.sort()
answer = []
# 중복 방지
visited = [False] * n

# 수열이 앞선 수보다 증가 한 숫자만 넣는다
def solution(count, max, find):
    if count == max:
        answer.append(find)
        return

    for i in range(len(nums)):
        if not visited[i]:
            visited[i] = True
            solution(count + 1, m, find + str(nums[i]) + " ")
            visited[i] = False
solution(0, m, "")

print("\n".join(answer))
