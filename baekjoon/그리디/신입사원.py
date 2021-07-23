import sys
n = int(input())
answer = []
for i in range(n):
    k1 = int(input())
    a = list()
    for i in range(k1):
        num = tuple(map(int, sys.stdin.readline().split()))
        a.append(num)
    a.sort()
    min = a[0][1]
    count = 1
    for i in range(k1):
        if min > a[i][1]:
            count += 1
            min = a[i][1]
    answer.append(count)        
for i in answer:
    print(i)