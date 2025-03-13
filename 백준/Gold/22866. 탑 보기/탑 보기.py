import sys

n = int(sys.stdin.readline().strip())
arr = list(map(int, sys.stdin.readline().split()))

count = [0] * n

near = [float("inf")] * n

rightStack = []
for i in range(n):
    while rightStack and arr[rightStack[-1]] <= arr[i]:
        rightStack.pop()

    count[i] += len(rightStack)

    if rightStack:
        near[i] = rightStack[-1]

    rightStack.append(i)


leftStack = []
for i in range(n - 1, -1, -1):
    while leftStack and arr[leftStack[-1]] <= arr[i]:
        leftStack.pop()
    count[i] += len(leftStack)

    if leftStack and abs(i - leftStack[-1]) < abs(i - near[i]):
        near[i] = leftStack[-1]

    leftStack.append(i)

for i in range(n):
    if count[i] == 0:
        print("0")
    else:
        print(count[i], near[i] + 1)