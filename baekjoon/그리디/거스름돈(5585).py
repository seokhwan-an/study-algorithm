money = int(input())
a = 1000 - money
exchage = [500,100,50,10,5,1]
count = 0
for i in exchage:
    count += a // i
    a = a % i

print(count)