import sys
n = int(sys.stdin.readline())
answer = []
for i in range(n):
    a, b = map(int,sys.stdin.readline().split())
    answer.append(a+b)
for i in answer:
    print(i)