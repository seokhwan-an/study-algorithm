answer = []
while True:
    try:
        a, b = map(int, input().split())
        answer.append(a+b)
    except:
        break

for i in answer:
    print(i)