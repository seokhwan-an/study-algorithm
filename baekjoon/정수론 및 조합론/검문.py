arr = []
answer = []
n = int(input())

for i in range(n):
    arr.append(int(input()))

arr.sort()
if arr[0] == 1:
    a = True
    for j in arr:
        if j % 2 == 0:
            a = False
            break
    if a:
        answer.append(2)
else:
    for i in range(2,arr[0]+1):
        a = True
        b = arr[0] % i # 이전 수의 나머지 값
        c = 0 # 현재 수의 나머지 값
        for j in arr:
            c = j % i
            if b != c:
                a = False
                break
        if a:
            answer.append(i)

for i in answer:
    print(i,end=" ")