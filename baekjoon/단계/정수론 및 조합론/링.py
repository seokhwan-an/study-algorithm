def gcd_sol(a,b):
    if b == 0:
        return a
    else:
        return gcd_sol(b,a%b)


n = int(input())
arr = list(map(int,input().split()))

answer = []

for i in range(1,n):
    if arr[0] % arr[i] == 0:
        answer.append(str(arr[0]//arr[i])+"/1")
    else:
        if arr[0] > arr[i]:
            a = arr[0]
            b = arr[i]
        else:
            a = arr[i]
            b = arr[0]
        gcd = gcd_sol(a,b)
        answer.append(str(arr[0]//gcd)+"/"+str(arr[i]//gcd))
    
for i in answer:
    print(i)