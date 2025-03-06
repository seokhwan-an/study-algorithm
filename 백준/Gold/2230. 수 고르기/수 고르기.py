import sys

n, m = map(int, sys.stdin.readline().split())
arr = []
for i in range(n):
    arr.append(int(sys.stdin.readline()))

arr.sort()
answer = float("inf")
start, end = 0, 0
diff = 0
while start <= end and end < len(arr):
    if diff >= m:
        answer = min(answer, diff)
        start += 1
        diff = arr[end] - arr[start]
    else:
        end += 1
        if end >= len(arr):
            break

        diff = arr[end] - arr[start]
print(answer)