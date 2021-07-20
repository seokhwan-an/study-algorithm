import math
n = int(input())
a = []
for i in range(n):
    a.append(list(map(int,input().split())))

for i in a:
    if i[0] == i[3] and i[1] == i[4]:
        if i[2] == i[5]:
            print(-1)
        else:
            print(0)
    else:
        b = math.sqrt((i[0]-i[3])**2+(i[1]-i[4])**2)
        c = i[2] + i[5]
        d = abs(i[2] - i[5])
        if d < b < c:
            print(2)
        elif b == d or b == c:
            print(1)
        else:
            print(0)