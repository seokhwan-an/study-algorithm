import sys

n, k = map(int,sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))

answer = 0
start, end, length = 0, 0, 0

# 현재 위치의 값이 홀수면 k - 1
# 짝수이면 length + 1
while end < len(arr):
    if arr[end] % 2 == 0:
        length += 1
        answer = max(answer, length)
    else:
        k -= 1

    while k < 0:
        num = arr[start]
        start += 1
        if num % 2 == 1:
            k += 1
            break
        else:
            length -= 1
    end += 1

print(answer)