a, b = map(int,input().split())
answer = []

while a != 0 and b != 0:
    answer.append(a+b)
    a, b = map(int,input().split())

for i in answer:
    print(i)