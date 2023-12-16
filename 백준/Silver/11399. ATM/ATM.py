n = int(input())
time = list(map(int,input().split()))
total = 0
if n == 1:
    print(time[0])
else:
    for i in range(n,0,-1):
        a = min(time)
        total += a*i
        time.remove(a)  
    print(total)