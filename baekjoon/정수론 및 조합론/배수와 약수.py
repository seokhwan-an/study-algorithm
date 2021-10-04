a,b = map(int,input().split())
answer = []
while(a != 0 and b != 0):
    if a > b:
        if a % b == 0:
            answer.append("multiple")
        else:
            answer.append("neither")

    else:
        if b % a == 0:
            answer.append("factor")
        else:
            answer.append("neither")
    a,b = map(int,input().split())

for i in answer:
    print(i)