a, b = map(int,input().split())

arr = [True]*(b+1)

for i in range(2, int(b**0.5)+1):
    if arr[i]:
        for j in range(i*i,b+1,i):
            arr[j] = False

for i in range(a,b+1):
    if arr[i] and i > 1:
        print(i)