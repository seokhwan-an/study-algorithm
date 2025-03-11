import sys

n = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))

m = int(sys.stdin.readline())
target = list(map(int, sys.stdin.readline().split()))

def isIn(arr, target):
    start = 0
    end = len(arr) - 1

    while (start <= end):
        mid = (start + end) // 2
        num = arr[mid]

        if num == target:
            return True
        elif num < target:
            start = mid + 1
        elif num > target:
            end = mid - 1

    return False

arr.sort()
answer = []
for i in target:
    if isIn(arr, i):
        answer.append(1)
    else:
        answer.append(0)

answer = "\n".join(map(str, answer))

print(answer)
