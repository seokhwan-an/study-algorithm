n = int(input())
money = []
sum = 0
for i in range(n):
    a = int(input())
    if a != 0:
        money.append(a)
    else:
        money.pop()

if len(money) == 0:
    sum == 0
else:
    for i in money:
        sum += i

print(sum)