m = int(input())
n = int(input())
prime = []
sum = 0
arr = [True]*(n+1)
for i in range(2,int(n**0.5)+1):
    if arr[i]:
        for j in range(i*i,n+1,i):
            arr[j] = False

for i in range(m, n+1):
    if i > 1 and arr[i] == True:
        prime.append(i)

for i in prime:
    sum += i

if len(prime) == 0:
    print(-1)
else:
    print(sum)
    print(prime[0])