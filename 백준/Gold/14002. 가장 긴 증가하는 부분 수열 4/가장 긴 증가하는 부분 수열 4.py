n = int(input())
nums = list(map(int, input().split()))

# 가장 처음의 수는 길이를 1로 갖는다.
# 이전 수와 비교해서 가장 긴 길이에 이어서 길이를 추가한다.
# 해당 문제는 가장 긴 수열도 포함해서 제공해야한다.

# 길이랑 해당 원소 넣기
dp = [0] * len(nums)
check = [[]] * len(nums)

for i in range(0, len(nums)):
    dp[i] = 1
    num = nums[i]
    check[i] = [num]
    for j in range(0, i):
        if num > nums[j]:
            if dp[j] + 1 > dp[i]:
                dp[i] = dp[j] + 1
                update = check[j][:]
                update.append(num)
                check[i] = update

max_len = 0
max_index = 0

for i in range(len(dp)):
    if dp[i] > max_len:
        max_len = dp[i]
        max_index = i

print(dp[max_index])
print(" ".join(map(str,check[max_index])))
