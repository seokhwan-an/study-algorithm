num = []
n = int(input())
while(n != 0):
    num.append(n)
    n = int(input())

for i in num:
    count = 0
    arr = [True] * (2*i+1)
    for j in range(2,int((2*i)**0.5)+1):
        if arr[j]:
            for k in range(j*j,2*i+1,j):
                arr[k] = False

    for j in range(i+1,2*i+1):
        if arr[j]:
            count += 1

    print(count)