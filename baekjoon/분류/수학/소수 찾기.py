n = int(input())
arr = list(map(int,input().split()))
count = 0
prime = [True]*1001
for i in range(2,int(1000**0.5)+1):
    if prime[i]:
        for j in range(i*i,1001,i):
            prime[j] = False

for i in arr:
    if i > 1 and prime[i]:
        count += 1

print(count)