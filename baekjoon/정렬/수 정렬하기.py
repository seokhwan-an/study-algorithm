n = int(input())
arr = []
for i in range(n):
    arr.append(int(input()))

for i in range(0,n-1):
    min = i
    for j in range(i,n):
        if arr[min] > arr[j]:
            min = j 
    temp = arr[i]
    arr[i] = arr[min]
    arr[min] = temp

for i in arr:
    print(i)     