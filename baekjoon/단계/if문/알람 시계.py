h, m = map(int,input().split())

answer = []

if m < 45:
    if h == 0:
        answer.append(23)
    else:
        answer.append(h-1)
    answer.append(60+m-45)
else:
    answer.append(h)
    answer.append(m-45)

for i in answer:
    print(i,end=" ")