def gcd_get(num1,num2):
    if num2 == 0:
        return num1
    else:
        return gcd_get(num2,num1%num2)

n = int(input())
answer = []
for i in range(n):
    a, b = map(int,input().split())
    if a > b:
        num1 = a
        num2 = b
    else:
        num1 = b
        num2 = a
    gcd = gcd_get(num1,num2)
    lcd = int(gcd * (num1/gcd) * (num2/gcd))
    answer.append(lcd)

for i in answer:
    print(i)