n, m = map(int, input().split())

answer = []
# 중복 방지

# 수열이 앞선 수보다 증가 한 숫자만 넣는다
def solution(nums, count, max, find, last):
    if count == max:
        answer.append(find)
        return

    for i in range(1, nums + 1):
        if i >= last:
            solution(nums, count + 1, m, find + str(i) + " ", i)
solution(n, 0, m, "", 0)

print("\n".join(answer))
