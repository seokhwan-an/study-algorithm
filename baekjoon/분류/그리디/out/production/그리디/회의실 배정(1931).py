import sys
n = int(input())
time = []
count=0
for i in range(n):
    time.append(tuple(map(int,sys.stdin.readline().split())))
while True:
    if len(time) == 0 :
        break
    else:
        time.sort(key=lambda time : time[1])
        min = time[0]    
        time = list(filter(lambda x : x[0] >= min[1], time))
        count += 1

print(count)