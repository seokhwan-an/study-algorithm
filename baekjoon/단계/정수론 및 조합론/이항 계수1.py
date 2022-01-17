a, b = map(int,input().split())
if b == 0:
    print(1)
else:
    answer = 1
    for i in range(b):
        answer = answer*(a-i)
    for i in range(b):
        answer = answer/(b-i)
    print(int(answer))