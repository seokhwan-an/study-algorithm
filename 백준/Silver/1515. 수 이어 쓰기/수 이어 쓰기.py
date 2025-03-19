import sys

num = sys.stdin.readline().strip()

answer = 1

start = 0
while True:
    check = str(answer)
    target = num[start : ]
    
    correct = 0
    for i in range(len(check)):
        if correct >= len(target):
            break
        if check[i] == target[correct]:
            correct += 1

    start += correct

    if start >= len(num):
        break

    answer += 1
print(answer)
