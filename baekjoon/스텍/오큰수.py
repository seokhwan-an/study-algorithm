n = int(input())
arr = list(map(int,input().split()))

answer = []
for i in range(0,n-1):
    nge = arr[i]
    for j in range(i+1,n):
        if arr[j] > nge:
            nge = arr[j]
            break

    if arr[i] == nge:
        answer.append(-1)
    else:
        answer.append(nge)
    
answer.append(-1)

for i in answer:
    print(i,end=" ")