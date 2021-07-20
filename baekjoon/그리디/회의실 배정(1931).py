n = int(input())
time = []
count=0
for i in range(n):
    time.append(tuple(map(int,input().split())))
time.sort()
min = time[0]    
while len(time) != 0:
    if count == 0:
        for i in time:
            if min[1] > i[1]:
                min = i
        time.remove(min)
        count += 1
    else:
        time = list(filter(lambda x : x[0] >= min[1],time))
        min = time[0]
        for i in time:
            if min[1] > i[1]:
                min = i
        time.remove(min)
        count += 1
print(count)   
