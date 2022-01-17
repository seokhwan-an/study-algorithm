t = int(input())
wave = [300,60,10]
count = [0,0,0]
for i in range(len(wave)):
    count[i] += t // wave[i]
    t = t % wave[i]
if t != 0:
    print(-1)
else:
    for i in count:
        print(i,end=" ")
    